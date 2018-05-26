package com.bian.product.order.service;

import com.bian.product.order.jooq.tables.pojos.Order;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import static com.bian.product.order.jooq.tables.Order.ORDER;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DSLContext create;

    @Override
    public Integer insert(Order order) {
        return create.insertInto(ORDER, ORDER.CREATETIME)
          .values(Timestamp.valueOf(LocalDateTime.now()))
          .execute();
    }

    @Override
    public List<Order> findAll() {
        return create.select()
          .from(ORDER)
          .fetchInto(Order.class);
    }
}
