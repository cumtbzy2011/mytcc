package com.bian.user.service;

import com.bian.user.jooq.tables.pojos.User;
import com.bian.user.jooq.tables.pojos.Userbalancetcc;
import com.bian.user.jooq.tables.records.UserbalancetccRecord;
import com.bian.user.model.TccStatus;
import org.jooq.DSLContext;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.bian.user.jooq.tables.User.USER_;
import static com.bian.user.jooq.tables.Userbalancetcc.USERBALANCETCC;

@Service
public class UserbalancetccServiceImpl implements UserbalancetccService {
    @Autowired
    DSLContext create;

    public int insert(Userbalancetcc userbalancetcc) {
        UserbalancetccRecord result = create.insertInto(USERBALANCETCC)
          .set(USERBALANCETCC.AMOUNT, userbalancetcc.getAmount())
          .set(USERBALANCETCC.T_USER_ID, userbalancetcc.getTUserId())
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
            throw new RuntimeException("用户不存在");
        }

        return trying(user, amount, 15);
    }

    @Transactional
    public Userbalancetcc trying(User user, long amount, long expireSeconds) {
        int isLock = consumeBalance(user.getId(), amount);
        if (isLock == 0) {
            throw new RuntimeException("预留余额失败");
        }
        Userbalancetcc userbalancetcc = new Userbalancetcc();
        userbalancetcc.setAmount(amount);
        userbalancetcc.setStatus((byte) TccStatus.TRYING);
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
    public int confirmReservation(Long id) {
        Userbalancetcc userbalancetcc = selectTccById(id);
        if (userbalancetcc == null) {
            throw new RuntimeException("resource " + id + " has been cancelled or does not exist at all");
        }
        if (TccStatus.TRYING == userbalancetcc.getStatus().intValue()) {
            int isSuccessful = updateToConfirmationById(userbalancetcc.getId());
            if (isSuccessful == 0) {
                throw new RuntimeException("resource " + id + " has been cancelled");
            }
        } else if (TccStatus.CANCEL == userbalancetcc.getStatus().intValue()) {
            throw new RuntimeException("resource " + id + " has been cancelled");
        }

        return 1;
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
          .and(USERBALANCETCC.STATUS.eq((byte) TccStatus.TRYING)
            .or(USERBALANCETCC.STATUS.eq((byte) TccStatus.CONFIRM)))
          .execute();
    }


    @Override
    @Transactional
    public int cancelReservation(Long id) {
        Userbalancetcc userbalancetcc = selectTccById(id);
        if (userbalancetcc == null) {
            throw new RuntimeException("resource " + id + " has been cancelled or does not exist at all");
        }

        if (userbalancetcc.getStatus().intValue() != TccStatus.CANCEL) {
            int deleteResult = deleteTryingById(userbalancetcc.getId());
            if (deleteResult == 1) {
                int i = returnBalance(userbalancetcc.getTUserId(), userbalancetcc.getAmount());
                if (i == 0) {
                    throw new IllegalStateException("回退余额失败");
                }
            }
        }

        return 1;
    }

    @Transactional
    public int cancelExpire(Userbalancetcc tcc) {
        int result = deleteTryingById(tcc.getId());
        if (result == 1) {
            int i = returnBalance(tcc.getTUserId(), tcc.getAmount());
            if (i == 0) {
                throw new IllegalStateException("回退余额失败");
            }
        }
        return 1;
    }

    private int deleteExpireById(ULong id) {
        return create.update(USERBALANCETCC)
          .set(USERBALANCETCC.STATUS, (byte) TccStatus.CANCEL)
          .where(USERBALANCETCC.ID.eq(id))
          .and(USERBALANCETCC.STATUS.eq((byte) TccStatus.TRYING))
          .execute();
    }


    private int returnBalance(ULong id, Long amount) {
        return create.update(USER_)
          .set(USER_.BALANCE, USER_.BALANCE.add(amount))
          .where(USER_.ID.eq(id))
          .execute();
    }

    private int deleteTryingById(ULong id) {
        return create.update(USERBALANCETCC)
          .set(USERBALANCETCC.STATUS, (byte) TccStatus.CANCEL)
          .where(USERBALANCETCC.ID.eq(id))
          .and(USERBALANCETCC.STATUS.ne((byte) TccStatus.CANCEL))
          .execute();
    }
}
