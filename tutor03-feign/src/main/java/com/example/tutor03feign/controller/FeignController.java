package com.example.tutor03feign.controller;

import com.example.tutor03feign.feign.FeignInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    @Autowired
    private FeignInterface feignInterface;

    @GetMapping("")
    public String hello() {
        return feignInterface.hello();
    }

}
