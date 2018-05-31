package com.bian.user.service;

import com.bian.user.jooq.tables.pojos.User;
import org.jooq.DSLContext;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bian.user.jooq.tables.User.USER_;

@Service
public class UserService {
    @Autowired
    DSLContext create;


    public User selectById(Long id) {
        List<User> users = create.select()
          .from(USER_)
          .where(USER_.ID.eq(ULong.valueOf(id)))
          .fetchInto(User.class);

        return users.size() > 0 ? users.get(0) : null;
    }

}
