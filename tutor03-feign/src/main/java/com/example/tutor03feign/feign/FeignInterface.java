package com.example.tutor03feign.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("tutor02-eureka-client")
public interface FeignInterface {
    @GetMapping("hello")
    public String hello();
}
