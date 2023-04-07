package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
//@EnableEurekaClient

public class CloudConsumerOrder80Application {

    public static void main(String[] args) {
        System.out.println("************80消费者启动成功************");
        ConfigurableApplicationContext run = SpringApplication.run(CloudConsumerOrder80Application.class, args);
        //2:查看容器  里所有的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        //3:遍历组件
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("*****************"+beanDefinitionName+"*****************");
        }
    }

}
