package com.jgz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 * EnableZuulProxy启动zuul网关
 * @author JGZ
 * CreateTime 2020/3/1 13:10
 * Email 1945282561@qq.com
 */
@EnableZuulProxy
@SpringBootApplication
public class ZullGateway9527_App {
    public static void main(String[] args) {
        SpringApplication.run(ZullGateway9527_App.class,args);
    }
}
