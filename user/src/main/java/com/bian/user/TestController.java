package com.bian.user;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.DiscoveryClient;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import com.netflix.discovery.shared.Applications;
import com.netflix.loadbalancer.ILoadBalancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.CloudEurekaClient;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
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
        RedisTemplate redisTemplate = null;
        redisTemplate.watch("local");
        redisTemplate.multi();
        redisTemplate.exec();


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


    @Autowired
    RedisTemplate<String, String> redisTemplate;

    public Object setRedis() {
        BoundValueOperations<String, String> testKey = redisTemplate.boundValueOps("testKey");
        HyperLogLogOperations<String, String> stringStringHyperLogLogOperations = redisTemplate.opsForHyperLogLog();

        testKey.set("test1");
        return "success";
    }

    public Object getRedis() {
        BoundValueOperations<String, String> testKey = redisTemplate.boundValueOps("testKey");
        String result = testKey.get();
        return result;
    }

    public Object testWatch1() {
        List<Object> execute = redisTemplate.execute(new SessionCallback<List<Object>>() {

            @Override
            public List<Object> execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.multi();
                redisOperations.opsForValue().set("testKey2", "test2");
                return redisOperations.exec();
            }
        });

        System.out.println(execute);
        return execute;
    }

    public List<Object> testPipe() {
        return redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
                redisConnection.set("key".getBytes(), "value".getBytes());
                return null;
            }
        });
    }


}
