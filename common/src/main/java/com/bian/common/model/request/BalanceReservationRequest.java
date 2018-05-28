package com.bian.common.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BalanceReservationRequest extends RestfulRequest {
    Long userId;

    Long amount;
}
