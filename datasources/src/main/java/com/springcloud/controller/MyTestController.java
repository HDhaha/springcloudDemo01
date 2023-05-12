package com.springcloud.controller;

import com.springcloud.service.MyTestService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @PostMapping("/te")
    public void test(){
        test.test();
    }
}
