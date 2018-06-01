package com.bian.user.service;

import com.bian.user.jooq.tables.pojos.Userbalancetcc;
import org.springframework.transaction.annotation.Transactional;

public interface UserbalancetccService {
    @Transactional
    Userbalancetcc trying(Long userId, long amount);

    @Transactional
    int confirmReservation(Long id);

    @Transactional
    int cancelReservation(Long id);
}
