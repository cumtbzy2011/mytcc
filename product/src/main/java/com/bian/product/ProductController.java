package com.bian.product;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class ProductController {


    @RequestMapping("say")
    public String product() {
        return "Product";
    }
}