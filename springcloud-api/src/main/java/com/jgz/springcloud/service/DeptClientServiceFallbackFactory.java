package com.jgz.springcloud.service;

import com.jgz.springcloud.entity.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * feign的服务降级工厂，当服务端不可用时，不会再通过feign去调用服务端，而是直接返回次类中配置的信息
 * @author JGZ
 * CreateTime 2020/3/1 10:24
 * Email 1945282561@qq.com
 */
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory<DeptClientService> {
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {

            /**
             * 服务端get方法调通直接执行这个方法
             * @param id
             * @return
             */
            @Override
            public Dept get(long id) {
                return new Dept().setDeptNo(id)
                        .setDeptName("该ID："+id+"没有没有对应的信息,Consumer客户端提供的降级信息,此刻服务Provider已经关闭")
                        .setDbSource("no this database in MySQL");
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Object discovery() {
                return null;
            }
        };
    }
}
