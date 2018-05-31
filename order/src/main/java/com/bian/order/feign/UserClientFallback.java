package com.bian.order.feign;

import com.bian.common.Shift;
import com.bian.common.StatusCode;
import com.bian.common.model.vo.Participant;
import com.bian.common.model.vo.VoUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@Slf4j
public class UserClientFallback implements UserClient {

    @Override
    public VoUser findUser(@PathVariable("userId") Long userId) {
        didNotGetResponse();
        Shift.fatal(StatusCode.SERVER_IS_BUSY_NOW);
        return null;
    }

    @Override
    public Long reserve(@RequestParam("userId") Long userId, @RequestParam("amount") Long amount) {
        didNotGetResponse();
        Shift.fatal(StatusCode.SERVER_IS_BUSY_NOW);
        return null;
    }

    @Override
    public int confirm(Long partId) {
        return 0;
    }

    private void didNotGetResponse() {
        log.error("service '{}' has become unreachable", "user");
    }
}
