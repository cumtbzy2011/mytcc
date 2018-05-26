package com.bian.user;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.loadbalancer.ILoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.CloudEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.inject.Provider;


@RestController
@RequestMapping("user")
public class TestController {
//
//    @Autowired
//    List<ILoadBalancer> loadBalancers = new ArrayList<>();

//    @Autowired
//    ILoadBalancer iLoadBalancer;

    @Autowired
    RestTemplate template;


    @Autowired
    Provider<EurekaClient> provider;

    @RequestMapping("usertest")
    public Object test() {
        EurekaClient eurekaClient = provider.get();
        Applications applications = eurekaClient.getApplications();
        List<Application> registeredApplications = applications.getRegisteredApplications();
        for (Application registeredApplication : registeredApplications) {
            List<InstanceInfo> instances = registeredApplication.getInstances();
            for (InstanceInfo instance : instances) {
                String ipAddr = instance.getIPAddr();
                String appName = instance.getAppName();
                Set<String> healthCheckUrls = instance.getHealthCheckUrls();
                int port = instance.getPort();
                String vipAddress = instance.getVIPAddress();
                System.out.println(vipAddress);
            }
        }
        return "success";
    }

    @RequestMapping("userba")
    public Object test2() {
//        System.out.println(loadBalancers.size());

        List<ClientHttpRequestInterceptor> interceptors = template.getInterceptors();

        ResponseEntity<String> forEntity = template.getForEntity("http://ORDER/order/say", String.class);
        System.out.println(forEntity.getBody());
        return "success";
    }

    @RequestMapping("useraa")
    public Object test3() {
        ResponseEntity<String> forEntity = template.getForEntity("http://PRODUCT/product/say", String.class);
        System.out.println(forEntity.getBody());

        return "success";
    }
}
