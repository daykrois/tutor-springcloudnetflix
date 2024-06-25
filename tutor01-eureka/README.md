# Spring-Cloud-Netflix 入门

## tutor01-eureka 是注册中心eureka-server
1. 添加依赖：
```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
</dependency>
```
2. 添加注解 @EnableEurekaServer
```java
@SpringBootApplication
@EnableEurekaServer
public class Tutor01EurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Tutor01EurekaApplication.class, args);
    }

}
```
3. 配置类
```properties
server.port=8761

#该Eureka客户端将不会向Eureka服务器注册自己，该服务实例不会出现在Eureka服务列表
eureka.client.register-with-eureka=false
#该Eureka客户端将不会从Eureka服务器获取服务注册表信息，即它不会拉取其他服务实例的注册信息列表
eureka.client.fetch-registry=false
```
4. 运行项目，访问localhost:8761
