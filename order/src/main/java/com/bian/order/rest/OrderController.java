package com.bian.order.rest;


import com.bian.order.jooq.tables.pojos.Order;
import com.bian.order.service.OrderService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //try
    @GetMapping("try")
    public Order placeOrder(@Valid PlaceOrderRequest request) {
        return orderService.placeOrder(request.getUserId(), request.getProductId());
    }

    //confirm
    @GetMapping("confirm")
    public Order payOff(@RequestParam Long orderId) {
        return orderService.confrim(orderId);
    }



    @Data
    class PlaceOrderRequest {
       @NotNull Long userId;
       @NotNull Long productId;
    }
}
