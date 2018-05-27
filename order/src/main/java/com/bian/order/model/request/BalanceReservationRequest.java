package com.bian.order.model.request;

import lombok.Data;

@Data
public class BalanceReservationRequest extends RestfulRequest {
    Long userId;

    Long amount;
}
