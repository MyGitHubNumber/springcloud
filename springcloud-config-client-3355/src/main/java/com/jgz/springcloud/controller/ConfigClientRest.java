package com.jgz.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 打印配置信息
 * @author JGZ
 * CreateTime 2020/3/2 13:56
 * Email 1945282561@qq.com
 */
@RestController
public class ConfigClientRest {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${eureka.client.service-url.defaultZone}")
    private String[] eurekaServers;

    @Value("${server.port}")
    private String port;

    @GetMapping("/config")
    public String getConfig()
    {
        String str = "applicationName: "+applicationName+"\t eurekaServers length:"+eurekaServers.length+"\t port: "+port;
        System.out.println("******str: "+ str);
        return "applicationName: "+applicationName+"\t eurekaServers length:"+eurekaServers.length+"\t port: "+port;
    }
}