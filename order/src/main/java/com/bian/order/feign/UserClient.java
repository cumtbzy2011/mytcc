package com.bian.order.feign;

import com.bian.common.model.vo.Participant;
import com.bian.common.model.vo.VoUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user", fallback = UserClientFallback.class)
public interface UserClient {

    String API_PATH = "rpc";

    @RequestMapping(value = API_PATH + "/user/{userId}", method = RequestMethod.GET)
    VoUser findUser(@PathVariable("userId") Long userId);

    @GetMapping(value = API_PATH + "/balances/reservation")
    Long reserve(@RequestParam("userId") Long userId, @RequestParam("amount") Long amount);

    @GetMapping(value = API_PATH + "/balances/confrm")
    int confirm(@RequestParam("partId") Long partId);
}
