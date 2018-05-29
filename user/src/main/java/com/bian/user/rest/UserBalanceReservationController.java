package com.bian.user.rest;

import com.bian.common.model.request.BalanceReservationRequest;
import com.bian.common.model.response.BalanceReservationResponse;
import com.bian.common.model.vo.Participant;
import com.bian.user.jooq.tables.pojos.Userbalancetcc;
import com.bian.user.service.UserbalancetccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rpc")
public class UserBalanceReservationController {

    @Value("${spring.application.name}")
    private String applicationName;
    @Autowired
    private UserbalancetccService tccService;

    @GetMapping(value = "/balances/reservation")
    public Participant reserve(@RequestBody BalanceReservationRequest request) {
        Userbalancetcc userbalancetcc = tccService.trying(request.getUserId(), request.getAmount());
        Participant participant = new Participant();
        participant.setUri("http://"+applicationName+"/rpc/balances/reservation/"+userbalancetcc.getId());
        participant.setExpireTime(userbalancetcc.getExpireTime().toLocalDateTime());
        return participant;
    }

    @PutMapping("/balances/reservation/{reservationId}")
    public void confirm(@PathVariable Long reservationId) {
        tccService.confirmReservation(reservationId);
    }

    @DeleteMapping("/balances/reservation/{reservationId}")
    public void cancel(@PathVariable Long reservationId) {
        tccService.cancelReservation(reservationId);
    }
}
