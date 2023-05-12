package com.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: HD
 * @remark: 多数据源配置切换
 */
@MapperScan(basePackages = "com.springcloud.mapper")
@SpringBootApplication
public class MyDateSourcesDemo {
    public static void main(String[] args) {
        SpringApplication.run(MyDateSourcesDemo.class,args);
    }
}