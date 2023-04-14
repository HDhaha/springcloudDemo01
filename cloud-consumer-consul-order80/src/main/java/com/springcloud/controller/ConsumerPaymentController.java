package com.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 申浩东
 */
@Slf4j
@RestController
@RequestMapping(value = "/consumer/payment")
public class ConsumerPaymentController {
//    private final static String PAYMENT_URL="http://localhost:8001/payment";
    //cloud-provider-payment
    private final static String PAYMENT_URL="http://cloud-provider-consul-payment11";
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping(value = "/consul")
    public String getPayment(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }

}