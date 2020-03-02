package com.jgz.springcloud.controller;

import com.jgz.springcloud.entity.Dept;
import com.jgz.springcloud.service.DeptClientService;
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
     * 将api中定义的feign接口注入
     */
    @Autowired
    private DeptClientService deptClientService;

    @PostMapping("/consumer/dept/add")
    public boolean add(Dept dept)
    {
        return deptClientService.add(dept);
    }

    @GetMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        return deptClientService.get(id);
    }

    @SuppressWarnings("unchecked")
    @GetMapping("/consumer/dept/list")
    public List<Dept> list()
    {
        return deptClientService.list();
    }

    //测试@EnableDiscoveryClient,消费端可以调用服务发现
    @GetMapping("/consumer/dept/discovery")
    public Object discovery()
    {
        return deptClientService.discovery();
    }
}
