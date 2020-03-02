package com.jgz.springcloud.controller;

import com.jgz.springcloud.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    /**
     * 未使用负载均衡
     */
    //private static final String REST_URL_PREFIX = "http://localhost:8001";
    /**
     * 使用负载均衡，将访问路径改为eureka上服务的名字即可
     */
    private static final String REST_URL_PREFIX = "http://SPRINGCLOUD-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return restTemplate.postForObject(REST_URL_PREFIX+"/dept/add", dept, Boolean.class);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/get/"+id, Dept.class);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/consumer/dept/list")
    public List<Dept> list()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/list", List.class);
    }

    //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @GetMapping("/consumer/dept/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(REST_URL_PREFIX+"/dept/discovery", Object.class);
    }
}
