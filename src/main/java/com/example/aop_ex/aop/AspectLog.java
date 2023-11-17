package com.example.aop_ex.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

@Slf4j
@Aspect
@Order(2)
public class AspectLog {

    @Before("com.example.aop_ex.aop.AspectPointCut.pointcutAllPostOrUser()")
    public void leaveLogBefore(JoinPoint joinPoint) throws Throwable {
        log.info("before method : {}", joinPoint.getSignature().getName());
    }

    @After("com.example.aop_ex.aop.AspectPointCut.pointcutUserOnly()")
    public void leaveLogAfter(JoinPoint joinPoint) throws Throwable {
        log.info("after method : {}", joinPoint.getSignature().getName());
    }
}
