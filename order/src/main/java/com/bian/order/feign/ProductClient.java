package com.bian.order.feign;


import com.bian.order.model.request.StockReservationRequest;
import com.bian.order.model.response.ObjectDataResponse;
import com.bian.order.model.response.ReservationResponse;
import com.bian.order.model.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "product", fallback = ProductFallback.class)
public interface ProductClient {

    String API_PATH = "/rpc";

    @RequestMapping(value = API_PATH + "/products/{id}", method = RequestMethod.GET)
    ObjectDataResponse<Product> findProduct(@PathVariable("id") Long productId);


    @RequestMapping(value = API_PATH + "/stocks/reservation",
      method = RequestMethod.POST,
      produces = {MediaType.APPLICATION_JSON_UTF8_VALUE},
      consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE})
    ReservationResponse reserve(@RequestBody StockReservationRequest request);


    @RequestMapping(value = API_PATH + "/test/{id}", method = RequestMethod.GET)
    ObjectDataResponse<String> test(@PathVariable("id") Long productId);
}
