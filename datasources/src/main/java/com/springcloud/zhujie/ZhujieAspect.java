package com.springcloud.zhujie;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;
import org.aspectj.lang.annotation.Before;
/**
 * @author: HD
 * @create: 2023/5/12
 * @remark:
 */
@Aspect
@Component
@Slf4j
public class ZhujieAspect {
    @Pointcut("@annotation(com.springcloud.zhujie.MyZhuJie)")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void execute(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        Method method = signature.getMethod();
        MyZhuJie annotation = method.getAnnotation(MyZhuJie.class);
        String value = annotation.value();
        System.out.println("本次值为++++"+value);
    }


}
