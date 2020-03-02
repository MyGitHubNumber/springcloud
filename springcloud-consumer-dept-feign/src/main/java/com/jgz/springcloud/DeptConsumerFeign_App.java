package com.jgz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * EnableEurekaClient 作为服务端连接eureka，好完成负载均衡
 * 部门服务的消费者，消费服务
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class DeptConsumerFeign_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumerFeign_App.class,args);
    }

}
