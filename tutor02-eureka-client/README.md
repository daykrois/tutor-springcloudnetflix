# Spring-Cloud-Netflix 入门

## tutor02-eureka-client 客户端服务注册到eureka-server
### 简介
Eureka-Client 是 Spring Cloud Eureka 项目中的一个组件，它用于实现微服务的注册和发现功能。当微服务启动时，它会将自己注册到 Eureka 服务器上，并将自身的状态信息（例如 IP 地址、端口等）同步到 Eureka 服务器。其他微服务可以通过 Eureka 服务器获取到注册微服务的状态信息，并基于这些信息进行调用。

Eureka-Client 的主要功能：
- 服务注册： 当微服务启动时，它会将自己注册到 Eureka 服务器上，并提供自身的状态信息。
- 服务发现： 其他微服务可以通过 Eureka 服务器获取到注册微服务的状态信息，并基于这些信息进行调用。
- 心跳机制： Eureka-Client 定期向 Eureka 服务器发送心跳信号，以保持服务实例的状态信息更新。
- 
Eureka-Client 的使用方式：
1. 在项目中添加 Eureka-Client 依赖。
2. 创建一个 Spring Boot 应用，并添加 @EnableEurekaClient 注解。
3. Eureka-Client 会自动与 Eureka 服务器进行连接，并完成服务注册和发现。



1. 添加依赖：
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```
2. 添加注解@EnableDiscoveryClient
```java
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
```
3. 配置类
```properties
spring.application.name=tutor02-eureka-client

server.port=8001

#注册地址
#eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```
4. 运行注册中心，在运行客户端项目运行项目，访问localhost:8761可以发现Instances currently registered with Eureka 这里的实例信息有实例TUTOR02-EUREKA-CLIENT
