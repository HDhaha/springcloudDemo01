package com.springcloud.controller;

import com.springcloud.domain.CommenResult;
import com.springcloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 申浩东
 */
@Slf4j
@RestController
@RequestMapping(value = "/consumer/payment")
public class ConsumerPaymentController {
//    private final static String PAYMENT_URL="http://localhost:8001/payment";
    private final static String PAYMENT_URL="http://PAYMENT-SERVICE/payment";

//    @Resource
//    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/getPayment")
    public CommenResult<Payment> getPayment(Integer id){
        log.info("*********payment="+id+"************");
        return restTemplate.getForObject(PAYMENT_URL+"/getPayment?id="+id, CommenResult.class);
    }

    @GetMapping(value = "/getPaymentEntity")
    public CommenResult<Payment> getPaymentEntity(Integer id){
        log.info("*********payment="+id+"************");
        ResponseEntity<CommenResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/getPayment?id=" + id, CommenResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return CommenResult.error();
        }
    }
    @PostMapping(value = "/insertPayment")
    public CommenResult<Payment> insertPayment(@RequestBody Payment payment){
        log.info("*********payment="+payment+"************");
        return restTemplate.postForObject(PAYMENT_URL+"/insertPayment",payment,CommenResult.class);
    }

    @PostMapping(value = "/insertPaymentEntity")
    public CommenResult<Payment> insertPaymentEntity(Payment payment){
        log.info("*********payment="+payment+"************");
        ResponseEntity<CommenResult> forEntity = restTemplate.postForEntity(PAYMENT_URL + "/insertPayment", payment, CommenResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else{
            return CommenResult.error();
        }
    }

    @PostMapping(value = "/updatePayment")
    public void updatePayment(@RequestBody Payment payment){
        log.info("*********payment="+payment+"************");
        restTemplate.put(PAYMENT_URL+"/updatePayment",payment,CommenResult.class);
    }

    @GetMapping("/cutom/loadbalance")
    public String getPaymentCutom(){
        //获取到   CLOUD-PAYMENT-SERVICE (提供者) 相应的实例
        return restTemplate.getForObject(PAYMENT_URL+"/custom/lb",String.class);
    }
}