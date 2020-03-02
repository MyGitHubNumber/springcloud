package com.jgz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * 只能监控有Hystrix熔断注解的方法调用
 * EnableHystrixDashboard开启hystrix断路器监控
 * @author JGZ
 * CreateTime 2020/3/1 11:27
 * Email 1945282561@qq.com
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashbord9001_App
{
    public static void main(String[] args)
    {
        SpringApplication.run(HystrixDashbord9001_App.class,args);
    }
}
