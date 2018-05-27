package com.bian.order.model.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderParticipant {

    private Long id;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private LocalDateTime deleteTime;

    String uri;
    LocalDateTime expireTime;
    Long orderId;
}
