package com.bian.common.model.vo;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VoParticipant {

    private Long id;
    @JsonDeserialize(using = LocalDateTImeDeserializer.class)
    private LocalDateTime createTime;
    @JsonDeserialize(using = LocalDateTImeDeserializer.class)
    private LocalDateTime updateTime;
    @JsonDeserialize(using = LocalDateTImeDeserializer.class)
    private LocalDateTime deleteTime;

    String uri;
    LocalDateTime expireTime;
    Long orderId;
}
