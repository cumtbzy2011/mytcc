package com.bian.common.model.request;

import lombok.Data;

@Data
public class StockReservationRequest extends RestfulRequest {

    Long productId;
}
