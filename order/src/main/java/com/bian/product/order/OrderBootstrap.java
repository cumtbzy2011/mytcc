package com.bian.product.order;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.client.ClientHttpRequestInterceptor;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(OrderBootstrap.class, args);
    }
}
