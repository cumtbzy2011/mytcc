package com.bian.order.feign;


import com.bian.common.model.vo.Participant;
import com.bian.order.model.request.StockReservationRequest;
import com.bian.order.model.response.ObjectDataResponse;
import com.bian.order.model.response.ReservationResponse;
import com.bian.order.model.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "product", fallback = ProductFallback.class)
public interface ProductClient {

    String API_PATH = "/rpc";

    @RequestMapping(value = API_PATH + "/product/{id}", method = RequestMethod.GET)
    Product findProduct(@PathVariable("id") Long productId);


    @GetMapping(value = API_PATH + "/stocks/reservation")
    Participant reserve(Long productId);


    @RequestMapping(value = API_PATH + "/test/{id}", method = RequestMethod.GET)
    ObjectDataResponse<String> test(@PathVariable("id") Long productId);
}
