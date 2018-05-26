package com.bian.order.service;

import com.bian.order.jooq.tables.pojos.Order;

import java.util.List;

public interface OrderService {
    int insert(Order order);

    List<Order> findAll();
}
