package com.bian.order.service;

import com.bian.order.jooq.tables.pojos.Conflict;
import org.jooq.DSLContext;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bian.order.jooq.tables.Conflict.CONFLICT;

@Service
public class ConflictServiceImpl implements ConflictService {
    @Autowired
    DSLContext create;


    public int insert(Conflict conflict) {
        return create.insertInto(CONFLICT)
          .set(CONFLICT.T_ORDER_ID, ULong.valueOf(1))
          .set(CONFLICT.ERROR_DETAIL, "test deatil")
          .execute();
    }
}
