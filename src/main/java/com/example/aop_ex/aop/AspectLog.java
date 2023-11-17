package com.example.aop_ex.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Slf4j
@Aspect
public class AspectLog {

    @Pointcut("execution(* com.example.aop_ex.service..*(..))")
    private void pointcutAllService() {

    }

    @Before("pointcutAllService()")
    public void leaveLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("before method : {}", joinPoint.getSignature().getName());
        // 무조건 작성해야 함!! 까먹음 주의!!
//        joinPoint.proceed();
//        log.info("after method : {}", joinPoint.getSignature().getName());
    }
}
