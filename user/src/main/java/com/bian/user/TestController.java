package com.bian.user;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.CloudEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;
import javax.inject.Provider;


@RestController
@RequestMapping("user")
public class TestController {

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
}
