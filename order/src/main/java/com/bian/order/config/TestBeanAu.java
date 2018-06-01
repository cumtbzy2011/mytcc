package com.bian.order.config;

import com.bian.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class TestBeanAu {

    @Autowired
    OrderService service;


    @Scheduled(fixedRate = 1000)
    public void say() {
        System.out.println("============================" +( service != null));
    }
}
