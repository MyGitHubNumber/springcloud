package com.jgz.springcloud.service;

import com.jgz.springcloud.entity.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * fallbackFactory在服务端调不通的时候调用该类中的指定方法
 * 作为feign的负载均衡调用
 * @author JGZ
 * CreateTime 2020/2/29 13:03
 * Email 1945282561@qq.com
 */
@FeignClient(value = "SPRINGCLOUD-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") long id);

    @GetMapping("/dept/list")
    public List<Dept> list();

    @PostMapping("/dept/add")
    public boolean add(Dept dept);

    @GetMapping("/dept/discovery")
    public Object discovery();
}
