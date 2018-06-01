package com.bian.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {


    @Bean
    public TestBeanAu createBea() {
        return new TestBeanAu();
    }
}
