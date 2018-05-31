package com.bian.order.feign;


import com.bian.common.model.vo.Participant;
import com.bian.order.model.response.ObjectDataResponse;
import com.bian.common.model.vo.VoProduct;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product", fallback = ProductFallback.class)
public interface ProductClient {

    String API_PATH = "/rpc";

    @RequestMapping(value = API_PATH + "/product/{id}", method = RequestMethod.GET)
    VoProduct findProduct(@PathVariable("id") Long productId);


    @GetMapping(value = API_PATH + "/stocks/reservation")
    Long reserve(@RequestParam("productId") Long productId);

    @GetMapping(value = API_PATH + "/stocks/confirm")
    Integer confirm(@RequestParam("partId") Long partId);
}
