package com.bian.user.config;

import com.bian.user.jooq.tables.pojos.Userbalancetcc;
import com.bian.user.service.UserbalancetccServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.bian.user.jooq.tables.Userbalancetcc.USERBALANCETCC;

@Slf4j
@Component
public class Config {
    @Autowired
    UserbalancetccServiceImpl userbalancetccService;

    @Autowired
    DSLContext create;


    @Scheduled(fixedRate = 1000)
    public void autoCancelTrying() {
        List<Userbalancetcc> userbalancetccs = create.select()
          .from(USERBALANCETCC)
          .where(USERBALANCETCC.EXPIRE_TIME.le(Timestamp.valueOf(LocalDateTime.now())))
          .fetchInto(Userbalancetcc.class);

        for (Userbalancetcc userbalancetcc : userbalancetccs) {
            try {
                userbalancetccService.cancelExpire(userbalancetcc);
            } catch (Exception e) {
                log.error("回收过期资源失败", e);
            }
        }
    }

}
