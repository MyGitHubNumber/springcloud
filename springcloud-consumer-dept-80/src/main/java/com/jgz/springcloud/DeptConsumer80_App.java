package com.jgz.springcloud;

import com.jgz.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * RibbonClient 使用我们自定义的负载均衡算法
 * EnableEurekaClient 作为服务端连接eureka，好完成负载均衡
 * 部门服务的消费者，消费服务
 */
@RibbonClient(name = "SPRINGCLOUD-DEPT",configuration = MySelfRule.class)
@EnableEurekaClient
@SpringBootApplication
public class DeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_App.class,args);
    }

}
