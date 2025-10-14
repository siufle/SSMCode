package com.xq.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 切面类
 */
public class MyAspect {

    //权限校验方法
    public void checkPrivilege(){
        System.out.println("正在进行权限校验");
    }

    //打印日志
    public void PrintLog(){
        System.out.println("打印日志");
    }

    //环绕通知
    public void around(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("通知1");
            //在该方法之前为前置通知 该方法之后为后置通知
            joinPoint.proceed();
            System.out.println("通知2");
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    //抛出异常通知
    public void throwing(){
        System.out.println("抛出异常通知");
    }

    //最终通知 无论是否抛出异常都会执行
    public void after(){
        System.out.println("最终通知");
    }
}
