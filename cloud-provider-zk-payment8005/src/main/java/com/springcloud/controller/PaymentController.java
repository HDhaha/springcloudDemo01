package com.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author 申浩东
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Value("${server.port}")
    private String servPort;
    @RequestMapping(value = "/zk")
    public Object paymentZK(){

        return "springcloud with zookeeper:"+servPort+"\t"+ UUID.randomUUID().toString();

    }
}
