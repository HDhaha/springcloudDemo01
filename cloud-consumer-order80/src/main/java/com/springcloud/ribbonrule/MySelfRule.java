//package com.springcloud.ribbonrule;
//
//import com.springcloud.cutom.MyLoadBalanceImpl;
//import org.springframework.cloud.client.ServiceInstance;
//import org.springframework.cloud.loadbalancer.core.ReactorLoadBalancer;
//import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
//import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.env.Environment;
//
////@Configuration
//public class MySelfRule {
////    @Bean
////    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
////                                                            LoadBalancerClientFactory loadBalancerClientFactory) {
////        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
////
////        return new RandomLoadBalancer(loadBalancerClientFactory
////                .getLazyProvider(name, ServiceInstanceListSupplier.class),
////                name);
////    }
//
//    //自定义负载均衡算法
//    @Bean
//    ReactorLoadBalancer<ServiceInstance> randomLoadBalancer(Environment environment,
//                                                            LoadBalancerClientFactory loadBalancerClientFactory) {
//        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//
////        这里返回了新的randomLoadBalancer
//        //这里返回了我自己定义的方法
//        return new MyLoadBalanceImpl(loadBalancerClientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
////        return new RandomLoadBalancer(loadBalancerClientFactory
////                .getLazyProvider(name, ServiceInstanceListSupplier.class),
////                name);
//    }
//}
