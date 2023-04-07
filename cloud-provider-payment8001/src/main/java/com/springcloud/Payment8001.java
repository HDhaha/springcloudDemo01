package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author:HD
 * @create:
 * @remark:
 */
@SpringBootApplication
public class Payment8001 {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Payment8001.class, args);
        //2:查看容器  里所有的组件
        String[] beanDefinitionNames = run.getBeanDefinitionNames();
        //3:遍历组件
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println("*****************" + beanDefinitionName + "*****************");
//        }
    }
}