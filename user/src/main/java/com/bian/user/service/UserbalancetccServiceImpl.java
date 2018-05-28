package com.bian.user.service;

import com.bian.common.Shift;
import com.bian.common.StatusCode;
import com.bian.common.exception.ReservationExpireException;
import com.bian.common.model.TccStatus;
import com.bian.user.jooq.tables.pojos.User;
import com.bian.user.jooq.tables.pojos.Userbalancetcc;
import com.bian.user.jooq.tables.records.UserbalancetccRecord;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.bian.user.jooq.tables.Userbalancetcc.USERBALANCETCC;
import static com.bian.user.jooq.tables.User.USER_;

@Service
public class UserbalancetccServiceImpl implements UserbalancetccService {
    @Autowired
    DSLContext create;

    public int insert(Userbalancetcc userbalancetcc) {
        UserbalancetccRecord result = create.insertInto(USERBALANCETCC)
          .set(USERBALANCETCC.AMOUNT, userbalancetcc.getAmount())
//          .set(USERBALANCETCC.STATUS, (byte) TccStatus.TRY)
          .set(USERBALANCETCC.T_USER_ID, userbalancetcc.getTUserId())
//          .set(USERBALANCETCC.CREATE_TIME, Timestamp.valueOf(LocalDateTime.now()))
          .set(USERBALANCETCC.EXPIRE_TIME, userbalancetcc.getExpireTime())
          .returning(USERBALANCETCC.ID)
          .fetchOne();
        userbalancetcc.setId(result.getId());
        return 1;
    }

    @Override
    @Transactional
    public Userbalancetcc trying(Long userId, long amount) {
        User user = selectUserById(userId);
        if (user == null) {
            Shift.fatal(StatusCode.USER_NOT_EXISTS);
        }

        return trying(user, amount, 15);
    }

    @Transactional
    public Userbalancetcc trying(User user, long amount, long expireSeconds) {
        int isLock = consumeBalance(user.getId(), amount);
        if (isLock == 0) {
            Shift.fatal(StatusCode.INSUFFICIENT_BALANCE);
        }
        Userbalancetcc userbalancetcc = new Userbalancetcc();
        userbalancetcc.setAmount(amount);
        userbalancetcc.setStatus((byte) TccStatus.TRY);
        userbalancetcc.setTUserId(user.getId());
        userbalancetcc.setExpireTime(Timestamp.valueOf(LocalDateTime.now().plusSeconds(expireSeconds)));
        this.insert(userbalancetcc);
        return userbalancetcc;
    }

    private User selectUserById(Long userId) {
        List<User> users = create.select()
          .from(USER_)
          .where(USER_.ID.eq(ULong.valueOf(userId)))
          .fetchInto(User.class);

        return users.size() > 0 ? users.get(0) : null;
    }

    private int consumeBalance(ULong userId, Long amount) {
        return create.update(USER_)
          .set(USER_.BALANCE, USER_.BALANCE.sub(amount))
          .where(USER_.ID.eq(userId))
          .and(USER_.BALANCE.ge(0L))
          .and(USER_.BALANCE.ge(USER_.BALANCE.sub(amount)))
          .execute();
    }


    @Override
    @Transactional
    public void confirmReservation(Long id) {
        Userbalancetcc userbalancetcc = selectTccById(id);
        if (userbalancetcc == null) {
            throw new ReservationExpireException("resource " + id + " has been cancelled or does not exist at all");
        }
        if (TccStatus.TRY == userbalancetcc.getStatus().intValue()) {
            int isSuccessful = updateToConfirmationById(userbalancetcc.getId());
            if (isSuccessful == 0) {
                throw new ReservationExpireException("resource " + id + " has been cancelled");
            }
        }
    }

    private Userbalancetcc selectTccById(Long id) {
        List<Userbalancetcc> userbalancetccs = create.select()
          .from(USERBALANCETCC)
          .where(USERBALANCETCC.ID.eq(ULong.valueOf(id)))
          .fetchInto(Userbalancetcc.class);

        return userbalancetccs.size() > 0 ? userbalancetccs.get(0) : null;
    }

    private int updateToConfirmationById(ULong id) {
        return create.update(USERBALANCETCC)
          .set(USERBALANCETCC.STATUS, (byte) TccStatus.CONFIRM)
          .where(USERBALANCETCC.ID.eq(id))
          .and(USERBALANCETCC.STATUS.eq((byte) TccStatus.TRY))
          .execute();
    }


    @Override
    @Transactional
    public void cancelReservation(Long id) {
        Userbalancetcc userbalancetcc = selectTccById(id);
        if (userbalancetcc == null) {
            throw new ReservationExpireException("resource " + id + " has been cancelled or does not exist at all");
        }

        if (userbalancetcc.getStatus().intValue() == TccStatus.TRY) {
            int deleteResult = deleteTryingById(userbalancetcc.getId());
            if (deleteResult == 0) {
                throw new ReservationExpireException("resource " + id + " has been cancelled");
            }
        }
    }

    private int deleteTryingById(ULong id) {
        return create.delete(USERBALANCETCC)
          .where(USERBALANCETCC.ID.eq(id))
          .and(USERBALANCETCC.STATUS.eq((byte) TccStatus.TRY))
          .execute();
    }
}
