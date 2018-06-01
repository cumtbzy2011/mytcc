package com.bian.user.rest;

import com.alibaba.fastjson.JSONObject;
import com.bian.user.jooq.tables.pojos.User;
import com.bian.user.jooq.tables.pojos.Userbalancetcc;
import com.bian.user.service.UserService;
import com.bian.user.service.UserbalancetccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rpc")
public class UserBalanceReservationController {

    @Value("${spring.application.name}")
    private String applicationName;
    @Autowired
    private UserbalancetccService tccService;

    @GetMapping(value = "/balances/reservation")
    public Long reserve(@RequestParam("userId") Long userId, @RequestParam("amount") Long amount) {
        Userbalancetcc userbalancetcc = tccService.trying(userId, amount);
        return userbalancetcc.getId().longValue();
    }

    @PutMapping("/balances/confirm")
    public int confirm(@RequestParam("partId") Long partId) {
        return tccService.confirmReservation(partId);
    }

    @DeleteMapping("/balances/reservation/{reservationId}")
    public int cancel(@PathVariable Long reservationId) {
       return tccService.cancelReservation(reservationId);
    }


    /////////////
    @Autowired
    UserService userService;


    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public JSONObject findById(@PathVariable("userId") Long userId) {
        User user = userService.selectById(userId);
        JSONObject result = new JSONObject();
        result.put("balance", user.getBalance());
        return result;
    }
}
