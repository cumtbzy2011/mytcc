package com.bian.order.feign;

import com.bian.common.Shift;
import com.bian.common.StatusCode;
import com.bian.order.model.request.TccRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Slf4j
public class TccClientFallback implements TccClient {

    @Override
    public void confirm(@RequestBody TccRequest request) {
        didNotGetResponse();
        Shift.fatal(StatusCode.SERVER_IS_BUSY_NOW);
    }

    @Override
    public void cancel(@RequestBody TccRequest request) {
        didNotGetResponse();
        Shift.fatal(StatusCode.SERVER_IS_BUSY_NOW);
    }

    private void didNotGetResponse() {
        log.error("service '{}' has become unreachable", "tcc");
    }
}
