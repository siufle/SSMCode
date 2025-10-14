package com.xq.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 切面类
 */
@Component
@Aspect //表明当前类是切面类
public class MyAspect {

    //定义切点
    @Pointcut(value = "execution(* com.xq.service.impl.UserServiceImpl.deleteUser(..))")
    public void pointCunt1(){

    }

    //权限校验方法
    //@Before(value = "execution(* com.xq.service.impl.UserServiceImpl.deleteUser(..))")//前置通知的注解
    @Before(value = "pointCunt1()")
    public void checkPrivilege(){
        System.out.println("正在进行权限校验");
    }

    //打印日志
    @AfterReturning(value = "execution(* com.xq.service.impl.UserServiceImpl.findAll(..))")//后置通知的注解
    public void PrintLog(){
        System.out.println("打印日志");
    }

    //环绕通知
    @Around(value = "execution(* com.xq.service.impl.UserServiceImpl.updateUser(..))")//环绕通知的注解
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
    @AfterThrowing(value = "execution(* com.xq.service.impl.UserServiceImpl.addUser(..))")//抛出异常通知的注解
    public void throwing(){
        System.out.println("抛出异常通知");
    }

    //最终通知 无论是否抛出异常都会执行
    @After(value = "execution(* com.xq.service.impl.UserServiceImpl.addUser(..))")//最终通知的注解
    public void after(){
        System.out.println("最终通知");
    }
}
