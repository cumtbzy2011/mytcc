package com.bian.rest;


import com.bian.common.model.request.TccRequest;
import com.bian.service.CoordinateControllerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rpc")
public class CoordinateController {

    @Autowired
    CoordinateControllerService service;


    @PutMapping("/coordinator/confirmation")
    public void confirm(@RequestBody TccRequest request) {
        service.confirm(request);
    }

    @PutMapping("/coordinator/cancellation")
    public void cancel(@RequestBody TccRequest request) {
        service.cancel(request);
    }
}
