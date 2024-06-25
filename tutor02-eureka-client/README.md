# Spring-Cloud-Netflix 入门

## tutor01-eureka 客户端服务注册到eureka-server
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
server.port=8001

#注册地址
#eureka.client.service-url.defaultZone=http://localhost:8761/eureka/
```
4. 运行项目，访问localhost:8761可以发现Instances currently registered with Eureka 这里的实例信息有实例TUTOR02-EUREKA-CLIENT
