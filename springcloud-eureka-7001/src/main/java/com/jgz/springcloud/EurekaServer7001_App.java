package com.jgz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka主管服务的注册与发现，与zookeeper功能类似
 * 所有的微服务都要注册到这个里面，我们也可以在这里管理我们的微服务
 * 所有的服务以心跳机制与eureka保持连接，我们也能通过它监控各个服务是否正常运行
 *
 * 打上EnableEurekaServer注解表示这个是个eureka服务端
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7001_App {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_App.class,args);
    }
}
