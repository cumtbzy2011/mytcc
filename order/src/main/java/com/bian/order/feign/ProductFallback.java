package com.bian.order.feign;

import com.bian.common.Shift;
import com.bian.common.StatusCode;
import com.bian.common.model.vo.Participant;
import com.bian.order.model.response.ObjectDataResponse;
import com.bian.common.model.vo.VoProduct;
import lombok.extern.slf4j.Slf4j;
import org.jooq.tools.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@Slf4j
public class ProductFallback implements ProductClient {

    @Override
    public VoProduct findProduct(@PathVariable("id") Long productId) {
        log.error("service product is unreachable");
        Shift.fatal(StatusCode.SERVER_IS_BUSY_NOW);
        return null;
    }

    @Override
    public Long reserve(Long productId) {
        log.error("service product is unreachable");
        Shift.fatal(StatusCode.SERVER_IS_BUSY_NOW);
        return null;
    }

    @Override
    public Integer confirm(Long partId) {
        return 0;
    }
}
