package com.bian.product.center;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class CenterBootstrap {
    public static void main(String[] args) {
        new SpringApplicationBuilder(CenterBootstrap.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
