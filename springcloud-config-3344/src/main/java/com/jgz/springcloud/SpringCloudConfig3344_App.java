package com.jgz.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * EnableConfigServer注解springcloud配置中心服务端
 * @author JGZ
 * CreateTime 2020/3/2 13:12
 * Email 1945282561@qq.com
 */
@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfig3344_App {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfig3344_App.class,args);
    }
}
