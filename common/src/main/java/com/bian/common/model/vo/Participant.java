package com.bian.common.model.vo;

import com.bian.common.model.TccEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Data
public class Participant {
    String uri;

    @JsonDeserialize(using = LocalDateTImeDeserializer.class)
    LocalDateTime expireTime;

    @JsonDeserialize(using = LocalDateTImeDeserializer.class)
    LocalDateTime executeTime;

    private ResponseEntity<?> participantErrorResponse;

    private TccEnum tccEnum = TccEnum.TO_BE_CONFIRMED;
}
