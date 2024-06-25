package com.example.tutor02eurekaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class Tutor02EurekaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tutor02EurekaClientApplication.class, args);
    }


    @GetMapping("hello")
    public String hello() {
        return "Hello Spring Cloud Eureka Client";
    }

}
