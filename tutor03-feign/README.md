# Spring-Cloud-Netflix 入门

## tutor03-feign 远程调用其他服务的方法

### 简介：
> 
> OpenFeign 是 Spring Cloud 项目中用于简化微服务间 HTTP 请求调用的声明式客户端组件。它通过声明式接口和注解的方式，让开发者无需编写大量的 HTTP 请求代码，即可实现微服务之间的调用。

1. 添加依赖：
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>
```
2. 添加注解 @EnableFeignClients
```java
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class Tutor03FeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tutor03FeignApplication.class, args);
    }

}
```
3. 配置类
```properties
spring.application.name=tutor03-feign

server.port=8002
```

4. 创建feign接口
> FeignClient的参数是其他服务的服务名
> 
> 声明式接口里面的方法签名完全和其他服务提供的一致，这里就是声明其他服务有什么方法，也就是本服务想要调用的方法
```java
@FeignClient("tutor02-eureka-client")
public interface FeignInterface {
    @GetMapping("hello")
    public String hello();
}
```
5. 创建controller，调用声明式接口
```java
@RestController
public class FeignController {
    @Autowired
    private FeignInterface feignInterface;

    @GetMapping("")
    public String hello() {
        return feignInterface.hello();
    }

}
```
6. 运行项目




