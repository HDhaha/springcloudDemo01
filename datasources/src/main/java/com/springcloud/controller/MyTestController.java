package com.springcloud.controller;

import com.springcloud.service.MyTestService;
import com.springcloud.util.DataSourceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: HD
 * @create: 2023/5/12
 * @remark:
 */
@RestController
@RequestMapping("/test")
public class MyTestController {
    @Autowired
    private MyTestService test;
//    @Value("${users.name}")
    private String name;
    @PostMapping("/te")
    public void test(){
        System.out.println("测试spring.pro.active==="+name);
        DataSourceUtil.setDB("db2");
        test.test();
    }
}
