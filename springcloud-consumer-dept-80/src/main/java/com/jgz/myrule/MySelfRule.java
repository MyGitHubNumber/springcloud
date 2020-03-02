package com.jgz.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RetryRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ribbon的配置类，不能在@ComponentScan所扫描的包中，否则达不到定制化的效果
 * 可以自定义配置类，继承AbstractLoadBalancerRule，并自写算法
 * @author JGZ
 * CreateTime 2020/2/29 11:09
 * Email 1945282561@qq.com
 */
@Configuration
public class MySelfRule {

    @Bean
    public IRule myRule(){
        return new RetryRule();
    }
}
