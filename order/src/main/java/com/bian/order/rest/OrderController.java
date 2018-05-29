package com.bian.order.rest;


import com.bian.order.jooq.tables.pojos.Order;
import com.bian.order.service.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("order")
public class OrderController {

    @RequestMapping("say")
    public String order() {
        return "order";
    }

    @Autowired
    OrderService orderService;

    @PostMapping
    public Order placeOrder(@Valid @RequestBody PlaceOrderRequest request) {
        return orderService.placeOrder(request.getUserId(), request.getProductId());
    }


    @Data
    class PlaceOrderRequest {
       @NotNull Long userId;
       @NotNull Long productId;
    }
}
