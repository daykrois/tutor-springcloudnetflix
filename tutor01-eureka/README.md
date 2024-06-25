# Spring-Cloud-Netflix 入门

## tutor01-eureka 是注册中心eureka-server
### 简介
Eureka-Server 是 Spring Cloud Eureka 项目中的一个组件，它用于作为服务注册中心，负责管理所有微服务的注册信息和服务状态。其他微服务（即 Eureka-Client）会将自身注册到 Eureka-Server 上，并定期向 Eureka-Server 发送心跳信号以保持状态更新。

Eureka-Server 的主要功能：
- 服务注册： 接收其他微服务（Eureka-Client）的注册请求，并存储服务实例的信息，例如 IP 地址、端口、状态等。
- 服务发现： 提供一个服务列表接口，供其他微服务（Eureka-Client）查询可用的服务实例信息。
- 心跳机制： 监听 Eureka-Client 发送的心跳信号，并根据心跳信号判断服务实例的状态（例如 UP、DOWN）。
- 服务实例剔除： 当 Eureka-Server 在一定时间内没有收到 Eureka-Client 的心跳信号时，会将其从服务列表中剔除，表示该服务实例已宕机。
- 健康检查： 可配置健康检查端点，用于监控服务实例的健康状态。

Eureka-Server 的使用方式：
1. 在项目中添加 Eureka-Server 依赖。
2. 创建一个 Spring Boot 应用，并添加 @EnableEurekaServer 注解。 
3. Eureka-Server 会自动启动并监听注册请求，并管理注册的微服务实例。


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
spring.application.name=tutor01-eureka

server.port=8761

#该Eureka客户端将不会向Eureka服务器注册自己，该服务实例不会出现在Eureka服务列表
eureka.client.register-with-eureka=false
#该Eureka客户端将不会从Eureka服务器获取服务注册表信息，即它不会拉取其他服务实例的注册信息列表
eureka.client.fetch-registry=false
```
4. 运行项目，访问localhost:8761
