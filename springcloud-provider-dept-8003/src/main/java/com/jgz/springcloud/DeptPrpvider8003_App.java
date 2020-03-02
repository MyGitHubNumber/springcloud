package com.jgz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 加上EnableEurekaClient表示改服务是eureka的客户端，它会被注册到eurekaServer中
 * 加上EnableDiscoveryClient则可以进行服务发现，给外部发现并使用
 * 部门服务的提供者启动类，提供服务
 */
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class DeptPrpvider8003_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptPrpvider8003_App.class,args);
    }
}
