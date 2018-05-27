package com.bian.order.feign;

import com.bian.common.Shift;
import com.bian.common.StatusCode;
import com.bian.order.model.request.StockReservationRequest;
import com.bian.order.model.response.ObjectDataResponse;
import com.bian.order.model.response.ReservationResponse;
import com.bian.order.model.vo.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Slf4j
public class ProductFallback implements ProductClient {

    @Override
    public ObjectDataResponse<Product> findProduct(@PathVariable("id") Long productId) {
        log.error("service product is unreachable");
        Shift.fatal(StatusCode.SERVER_IS_BUSY_NOW);
        return null;
    }

    @Override
    public ReservationResponse reserve(@RequestBody StockReservationRequest request) {
        log.error("service product is unreachable");
        Shift.fatal(StatusCode.SERVER_IS_BUSY_NOW);
        return null;
    }

    @Override
    public ObjectDataResponse<String> test(Long productId) {
        throw new RuntimeException("test error");
    }
}
