package com.example.aop_ex.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Slf4j
@Aspect
@Order(1)
public class AspectPerformance {

    @Around("com.example.aop_ex.aop.AspectPointCut.pointcutPostOnly()")
    public void leaveLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("method 실행되기 전 시간 체크 : {}", joinPoint.getSignature().getName());
        long start = System.currentTimeMillis();
        // 무조건 작성해야 함!! 까먹음 주의!!
        joinPoint.proceed();
        long end = System.currentTimeMillis();
        log.info("method 실행에 걸린 시간은 : {} , {}", joinPoint.getSignature().getName(), (end - start));
    }
}
