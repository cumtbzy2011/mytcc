package com.bian.user.service;

import com.bian.user.jooq.tables.pojos.Userbalancetcc;
import org.springframework.transaction.annotation.Transactional;

public interface UserbalancetccService {
    @Transactional
    Userbalancetcc trying(Long userId, long amount);

    @Transactional
    void confirmReservation(Long id);

    @Transactional
    void cancelReservation(Long id);
}