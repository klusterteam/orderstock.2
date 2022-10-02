package com.kluster.orderstock_2.member.aop;

import org.springframework.stereotype.Component;

@Component
public class TimeTraceAop {

    /* 변경사항 수정 */
    /*@Around("execution(* com.kluster.orderstock_2..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint)throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("START : " + joinPoint.toString() + "<-- 접속 시간");
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("END : "+ joinPoint.toString() + " " + timeMs+" ms <-- 종료 시간");
        }
    }*/
}
