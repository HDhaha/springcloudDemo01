package com.springcloud.zhujie;

import org.junit.Test;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: HD
 * @create: 2023/5/12
 * @remark:
 */
@RestController
@RequestMapping("/zj")
public class TestZhujie {
    @MyZhuJie("ceshi")
    String name;


    @MyZhuJie("haha")
    @PostMapping("/te1")
    public  void test() {
        System.out.println(name);
    }
}
