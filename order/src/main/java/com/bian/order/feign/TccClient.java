package com.bian.order.feign;

import com.bian.order.model.request.TccRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "tcc", fallback = TccClientFallback.class)
public interface TccClient {
    String API_PATH = "/rpc";

    @RequestMapping(value = API_PATH + "/confirmation", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    void confirm(@RequestBody TccRequest request);

    @RequestMapping(value = API_PATH + "/cancellation", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_JSON_UTF8_VALUE}, consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    void cancel(@RequestBody TccRequest request);
}
