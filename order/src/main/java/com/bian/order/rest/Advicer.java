package com.bian.order.rest;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class Advicer {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public JSONObject handler(Exception e) {
        String message = e.getMessage();
        JSONObject result = new JSONObject();
        result.put("code", "500");
        result.put("message", message);
        return result;
    }
}
