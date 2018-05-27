package com.bian.order.model.request;

import lombok.Data;
import org.jooq.types.ULong;

@Data
public class StockReservationRequest extends RestfulRequest {

    ULong productId;
}
