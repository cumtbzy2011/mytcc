package com.bian.order.feign;

import com.bian.common.model.vo.Participant;
import com.bian.order.model.vo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user", fallback = UserClientFallback.class)
public interface UserClient {

    String API_PATH = "rpc";

    @RequestMapping(value = API_PATH + "/user/{userId}", method = RequestMethod.GET)
    User findUser(@PathVariable("userId") Long userId);

    @GetMapping(value = API_PATH + "/balances/reservation")
    Participant reserve(@RequestParam Long userId, @RequestParam Long amount);
}
