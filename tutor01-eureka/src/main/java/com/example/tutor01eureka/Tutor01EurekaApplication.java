package com.example.tutor01eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Tutor01EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tutor01EurekaApplication.class, args);
    }

}
