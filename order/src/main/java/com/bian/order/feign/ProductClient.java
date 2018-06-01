package com.bian.order.feign;


import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product", fallback = ProductFallback.class)
public interface ProductClient {

    String API_PATH = "/rpc";

    @RequestMapping(value = API_PATH + "/product/{id}", method = RequestMethod.GET)
    JSONObject findProduct(@PathVariable("id") Long productId);


    @GetMapping(value = API_PATH + "/stocks/reservation")
    Long trying(@RequestParam("productId") Long productId);

    @GetMapping(value = API_PATH + "/stocks/confirm")
    int confirm(@RequestParam("partId") Long partId);
}
