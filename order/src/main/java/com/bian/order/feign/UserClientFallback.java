package com.bian.order.feign;

import com.alibaba.fastjson.JSONObject;
import com.bian.order.model.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Slf4j
public class UserClientFallback implements UserClient {

    @Override
    public JSONObject findUser(@PathVariable("userId") Long userId) {
        didNotGetResponse();
        throw new SystemException("user client findUser callback");
    }

    @Override
    public Long trying(@RequestParam("userId") Long userId, @RequestParam("amount") Long amount) {
        didNotGetResponse();
        throw new SystemException("user client trying-balance callback");
    }

    @Override
    public int confirm(Long partId) {
        return 0;   //0代表未成功确认资源
    }

    private void didNotGetResponse() {
        log.error("service '{}' has become unreachable", "user");
    }
}
