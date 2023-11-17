package com.example.aop_ex.aop;

import org.aspectj.lang.annotation.Pointcut;

public class AspectPointCut {

//    매칭조건
//    1) 접근제어자 : 생략(private, public)
//    2) 반환타입 : *
//    3) 선언타입? : 생략
//    4) 메서드 이름 *
//    5) 파라미터 (..)
//       5-1) (), (*), (*,*), (..), (String), (String, Xxx), (String , Xxx, Xxx)
//    6) 예외

//    Before
    @Pointcut("execution(* *..Post*.*(..))")
    public void pointcutPostOnly() {}

//    After
    @Pointcut("execution(* *..User*.*(..))")
    public void pointcutUserOnly() {}

//    Performance
    @Pointcut("pointcutPostOnly() || pointcutUserOnly()")
    public void pointcutAllPostOrUser() {}
}
