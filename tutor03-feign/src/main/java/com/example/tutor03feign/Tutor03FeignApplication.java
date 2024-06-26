package com.example.tutor03feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Tutor03FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tutor03FeignApplication.class, args);
    }

}
