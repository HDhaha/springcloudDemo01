package com.springcloud.config;

//import com.springcloud.ribbonrule.MySelfRule;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
//import com.springcloud.ribbonrule.MySelfRule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 * @author 申浩东
 */
@Configuration
//注意这里的name属性 需要和eureka页面中的服务提供者名字一直 此时页面中是大写
//@LoadBalancerClient(name = "PAYMENT-SERVICE",configuration= MySelfRule.class)
public class ApplicationContextConfig {
    @Bean      //将这个对象放入ioc容器
    @LoadBalanced //使用@LoadBalanced注解赋予RestTemplate负载均衡的能力  默认是轮询
    //相当于  <bean id="" class="" />
    public RestTemplate re(){
        return new RestTemplate();
    }
//    RestOperations restTemplate(RestTemplateBuilder builder) {
//        return builder.build();
//    }
}
