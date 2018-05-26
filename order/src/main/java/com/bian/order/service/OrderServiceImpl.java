package com.bian.order.service;

import com.bian.order.jooq.tables.pojos.Order;
import org.jooq.DSLContext;
import org.jooq.types.UInteger;
import org.jooq.types.ULong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bian.order.jooq.tables.Order.ORDER_;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    DSLContext create;

    @Override
    public int insert(Order order) {
        return create.insertInto(ORDER_)
          .set(ORDER_.USER_ID, ULong.valueOf(1))
          .set(ORDER_.PRODUCT_ID, ULong.valueOf(1))
          .set(ORDER_.PRICE, UInteger.valueOf(10))
          .execute();
    }

    @Override
    public List<Order> findAll() {
        return create.select()
          .from(ORDER_)
          .fetchInto(Order.class);
    }
}
