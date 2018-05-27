package com.bian.order.feign;

import com.bian.order.model.request.BalanceReservationRequest;
import com.bian.order.model.response.ObjectDataResponse;
import com.bian.order.model.response.ReservationResponse;
import com.bian.order.model.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "user", fallback = UserClientFallback.class)
public interface UserClient {

    String API_PATH = "rpc";

    @RequestMapping(value = API_PATH + "/users/{userId}", method = RequestMethod.GET)
    ObjectDataResponse<User> findUser(@PathVariable("userId") Long userId);

    @RequestMapping(value = API_PATH + "/balances/reservation", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    ReservationResponse reserve(@RequestBody BalanceReservationRequest request);
}
