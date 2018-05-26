package com.bian.user.service;

import com.bian.user.jooq.tables.pojos.Userbalancetcc;
import org.jooq.DSLContext;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bian.user.jooq.tables.Userbalancetcc.USERBALANCETCC;

@Service
public class UserbalancetccServiceImpl implements UserbalancetccService {
    @Autowired
    DSLContext create;

    public int insert(Userbalancetcc userbalancetcc) {
        return create.insertInto(USERBALANCETCC)
          .set(USERBALANCETCC.AMOUNT, 1L)
          .set(USERBALANCETCC.STATUS, (byte) 1)
          .set(USERBALANCETCC.T_USER_ID, ULong.valueOf(1))
          .execute();
    }
}
