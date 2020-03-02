package com.jgz.springcloud.controller;

import com.jgz.springcloud.entity.Dept;
import com.jgz.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
public class DepController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/dept/add")
    public boolean add(@RequestBody Dept dept){
        return deptService.add(dept);
    }

    /**
     * HystrixCommand调用失败抛出异常或超时则直接触发fallbackMethod指定的方法
     * @param id
     * @return
     */
    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id")Long id){
//        try {
//            TimeUnit.SECONDS.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        int i = 1/0;
        return deptService.get(id);
    }
    public Dept processHystrix_Get(@PathVariable("id")Long id){
        return new Dept().setDeptNo(id).setDeptName("该信息不存在").setDbSource("该信息不存在");
    }


    @GetMapping("/dept/list")
    public List<Dept> list(){
        return deptService.list();
    }

    @GetMapping(value = "/dept/discovery")
    public Object discovery()
    {
        List<String> list = discoveryClient.getServices();
        System.out.println("**********" + list);

        List<ServiceInstance> srvList = discoveryClient.getInstances("SPRINGCLOUD-DEPT");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.discoveryClient;
    }

}
