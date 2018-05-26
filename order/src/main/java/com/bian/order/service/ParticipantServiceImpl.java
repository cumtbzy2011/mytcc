package com.bian.order.service;

import com.bian.order.jooq.tables.pojos.Participant;
import org.jooq.DSLContext;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import static com.bian.order.jooq.tables.Participant.PARTICIPANT;

@Service
public class ParticipantServiceImpl implements ParticipantService {
    @Autowired
    DSLContext create;


    public int insert(Participant participant) {
        return create.insertInto(PARTICIPANT)
          .set(PARTICIPANT.EXPIRE_TIME, Timestamp.valueOf(LocalDateTime.now()))
          .set(PARTICIPANT.URI, "testuri")
          .set(PARTICIPANT.T_ORDER_ID, ULong.valueOf(1))
          .execute();
    }
}
