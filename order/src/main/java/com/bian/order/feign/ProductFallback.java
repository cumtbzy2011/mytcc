package com.bian.order.feign;

import com.alibaba.fastjson.JSONObject;
import com.bian.order.model.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@Slf4j
public class ProductFallback implements ProductClient {

    @Override
    public JSONObject findProduct(@PathVariable("id") Long productId) {
        log.error("service product is unreachable");
        throw new SystemException("product client findProduct callback");
    }

    @Override
    public Long trying(Long productId) {
        log.error("service product is unreachable");
        throw new SystemException("product client trying-stock callback");
    }

    @Override
    public int confirm(Long partId) {
        return 0;
    }
}
