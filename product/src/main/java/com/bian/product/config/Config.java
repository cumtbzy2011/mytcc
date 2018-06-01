package com.bian.product.config;

import com.bian.product.jooq.tables.pojos.Productstocktcc;
import com.bian.product.service.ProductstocktccService;
import com.bian.product.service.ProductstocktccServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.bian.product.jooq.tables.Productstocktcc.PRODUCTSTOCKTCC;

@Component
@Slf4j
public class Config {
    @Autowired
    ProductstocktccServiceImpl productstocktccService;

    @Autowired
    DSLContext create;


    @Scheduled(fixedRate = 1000)
    public void autoCancelTrying() {
        // 获取过期的资源
        final List<Productstocktcc> reservations = create.select()
          .from(PRODUCTSTOCKTCC)
          .where(PRODUCTSTOCKTCC.EXPIRE_TIME.le(Timestamp.valueOf(LocalDateTime.now())))
          .fetchInto(Productstocktcc.class);

        for (Productstocktcc res : reservations) {
            try {
                productstocktccService.cancelExpire(res);
            } catch (Exception e) {
                log.error("回收一个过期资源失败：", e);
            }
        }
    }
}
