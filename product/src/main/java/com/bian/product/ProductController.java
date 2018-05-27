package com.bian.product;

import com.bian.product.model.ObjectDataResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rpc")
public class ProductController {


    @RequestMapping("say")
    public String product() {
        return "Product";
    }


    @GetMapping("/test/{id}")
    public ObjectDataResponse<String> test(@PathVariable("id") Long id) {
        System.out.println("from rpc: " + id);
        return new ObjectDataResponse<>("hello world");
    }
}
