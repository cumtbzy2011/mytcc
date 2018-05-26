package com.bian.product.order.service;

import com.bian.product.order.jooq.tables.pojos.Order;

import java.util.List;

public interface OrderService {
    Integer insert(Order order);

    List<Order> findAll();
}
