package com.springcloud.controller;

import com.springcloud.domain.CommenResult;
import com.springcloud.domain.Payment;
import com.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: HD
 * @create: 2023/4/7
 * @remark:
 */
@Slf4j
@RestController
@RequestMapping(value = "/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
//    @Resource
//    private DiscoveryClient discoveryClient;

    /**
     * RequestBody  表示传递的参数格式为json  ,如果要直接访问的话,参数需要以json格式请求
     *
     * @param payment
     * @return
     */
    @PostMapping(value = "/insertPayment")
    public CommenResult<Payment> insertPayment(@RequestBody Payment payment) {
        log.info("***********获取到流水号*********: " + payment);
        int i = paymentService.insertPayment(payment);
        if (i > 0) {
            return new CommenResult(200, "插入数据成功,serverport=" + serverPort, i);
        } else {
            return new CommenResult(0, "插入数据失败,serverport=" + serverPort, null);
        }
    }

    @GetMapping(value = "/getPayment")
    public CommenResult<Payment> getPayment(@RequestParam("id") Integer id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查到的流水号为: " + payment);
        log.info("======================");
        log.info("======================");
        if (payment != null) {
            return new CommenResult(200, "查询成功,serverport=" + serverPort, payment);
        } else {
            return new CommenResult(0, "该id为空: " + id + ",serverport=" + serverPort, null);
        }
    }

    @GetMapping(value = "/getPayment/{id}")
    public CommenResult<Payment> getPaymentPathVariable(@PathVariable("id") Integer id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查到的流水号为: " + payment);
        log.info("======================");
        log.info("======================");
        if (payment != null) {
            return new CommenResult(200, "查询成功,serverport=" + serverPort, payment);
        } else {
            return new CommenResult(0, "该id为空: " + id + ",serverport=" + serverPort, null);
        }
    }

    @PutMapping("/updatePayment")
    public CommenResult updatePayment(@RequestBody Payment payment) {
        int i = paymentService.updatePayment(payment);
        return CommenResult.toCommentResult(i);
    }

//    @GetMapping(value = "/discoveryClient")
//    public Object discoveryClient() {
//        //获取到所有服务
//        List<String> services = discoveryClient.getServices();
//        services.forEach(service -> System.out.println("******service******" + service));
//        //获取到指定服务的实例
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        instances.forEach(instance -> System.out.println(instance.getInstanceId() + "\t" + instance.getPort() + "\t" +
//                instance.getHost() + "\t" + instance.getUri()));
//        return discoveryClient;
//    }
}
