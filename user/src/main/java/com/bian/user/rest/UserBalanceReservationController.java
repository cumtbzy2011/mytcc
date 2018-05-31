package com.bian.user.rest;

import com.bian.common.model.request.BalanceReservationRequest;
import com.bian.common.model.vo.Participant;
import com.bian.common.model.vo.VoUser;
import com.bian.user.jooq.tables.pojos.User;
import com.bian.user.jooq.tables.pojos.Userbalancetcc;
import com.bian.user.service.UserService;
import com.bian.user.service.UserbalancetccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public void confirm(@RequestParam("partId") Long partId) {
        tccService.confirmReservation(partId);
    }

    @DeleteMapping("/balances/reservation/{reservationId}")
    public void cancel(@PathVariable Long reservationId) {
        tccService.cancelReservation(reservationId);
    }


    /////////////
    @Autowired
    UserService userService;


    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public VoUser findById(@PathVariable("userId") Long userId) {
        User user = userService.selectById(userId);
        VoUser voUser = new VoUser();
        voUser.setBalance(user.getBalance());
        voUser.setCreateTime(user.getCreateTime().toLocalDateTime());
        voUser.setDeleteTime(user.getDeleteTime().toLocalDateTime());
        voUser.setUpdateTime(user.getUpdateTime().toLocalDateTime());
        voUser.setId(user.getId().longValue());
        voUser.setLoginPwd(user.getLoginPwd());
        voUser.setMobile(user.getMobile());
        voUser.setPwdSalt(user.getPwdSalt());

        return voUser;
    }
}
