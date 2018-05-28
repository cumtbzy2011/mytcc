package com.bian.service;

import com.bian.common.Shift;
import com.bian.common.StatusCode;
import com.bian.common.TccErrorResponse;
import com.bian.common.exception.PartialConfirmException;
import com.bian.common.exception.ReservationExpireException;
import com.bian.common.model.request.TccRequest;
import com.bian.common.model.vo.Participant;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class CoordinateControllerServiceImpl implements CoordinateControllerService {
    @Autowired
    RestTemplate restTemplate;

    private static final HttpEntity<?> REQUEST_ENTITY;

    static {
        final HttpHeaders header = new HttpHeaders();
        header.setAccept(ImmutableList.of(MediaType.APPLICATION_JSON_UTF8));
        header.setContentType(MediaType.APPLICATION_JSON_UTF8);
        REQUEST_ENTITY = new HttpEntity<>(header);
    }


    public void confirm(TccRequest request) {
        List<Participant> participantLinks = request.getParticipantLinks();

        int success = 0;
        int fail = 0;
        for (Participant participantLink : participantLinks) {
            ResponseEntity<String> response = restTemplate.exchange(participantLink.getUri(), HttpMethod.PUT, REQUEST_ENTITY, String.class);
            if (response.getStatusCode() == HttpStatus.CONFLICT) {
                success++;
            } else if (response.getStatusCode() == HttpStatus.NOT_FOUND) {
                fail++;
            } else {
                Shift.fatal(StatusCode.SERVER_UNKNOWN_ERROR, response);
            }
        }

        if (success > 0 && fail > 0) {
            throw new PartialConfirmException("all reservation were cancelled or timeout", new TccErrorResponse(participantLinks));
        } else if (fail == participantLinks.size()) {
            throw new ReservationExpireException("although we have check the expire time in request body, we got an expiration when confirming actually");
        }
    }

    public void cancel(TccRequest request) {
        final List<Participant> participantList = Preconditions.checkNotNull(request.getParticipantLinks());
        try {
            for (Participant participant : participantList) {
                restTemplate.exchange(participant.getUri(), HttpMethod.DELETE, null, String.class);
            }
        } catch (Exception e) {
            log.debug("unexpected error when making compensation: {}", e.toString());
        }
    }
}
