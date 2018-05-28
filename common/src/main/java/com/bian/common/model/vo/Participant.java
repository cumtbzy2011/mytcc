package com.bian.common.model.vo;

import com.bian.common.model.TccEnum;
import lombok.Data;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Data
public class Participant {
    String uri;

    LocalDateTime expireTime;

    LocalDateTime executeTime;

    private ResponseEntity<?> participantErrorResponse;

    private TccEnum tccEnum = TccEnum.TO_BE_CONFIRMED;
}
