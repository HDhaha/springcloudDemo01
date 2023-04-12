package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author:HD
 * @create:
 * @remark:
 */
@SpringBootApplication
@EnableEurekaClient   //代表此服务为服务注册 客户端
public class Payment8002 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Payment8002.class, args);
        //2:查看容器  里所有的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        //3:遍历组件
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println("*****************" + beanDefinitionName + "*****************");
//        }
    }
}