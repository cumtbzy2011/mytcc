package com.bian.order.feign;

import com.bian.common.Shift;
import com.bian.common.StatusCode;
import com.bian.order.model.request.BalanceReservationRequest;
import com.bian.order.model.response.ObjectDataResponse;
import com.bian.order.model.response.ReservationResponse;
import com.bian.order.model.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@Slf4j
public class UserClientFallback implements UserClient {

    @Override
    public ObjectDataResponse<User> findUser(@PathVariable("userId") Long userId) {
        didNotGetResponse();
        Shift.fatal(StatusCode.SERVER_IS_BUSY_NOW);
        return null;
    }

    @Override
    public ReservationResponse reserve(@RequestBody BalanceReservationRequest request) {
        didNotGetResponse();
        Shift.fatal(StatusCode.SERVER_IS_BUSY_NOW);
        return null;
    }

    private void didNotGetResponse() {
        log.error("service '{}' has become unreachable", "user");
    }
}
