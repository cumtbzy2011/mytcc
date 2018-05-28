package com.bian;

import com.bian.model.TccResponseErrorHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class CoordinatorBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(CoordinatorBootstrap.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        final RestTemplate template = new RestTemplate();
        template.setErrorHandler(new TccResponseErrorHandler());
        return template;
    }
}
