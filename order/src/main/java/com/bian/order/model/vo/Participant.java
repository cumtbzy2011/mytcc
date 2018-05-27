package com.bian.order.model.vo;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class Participant {

    String uri;

    LocalDateTime timestamp;
}
