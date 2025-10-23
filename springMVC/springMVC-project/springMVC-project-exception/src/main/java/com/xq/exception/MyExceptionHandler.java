package com.xq.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 自定义异常处理类
 */
//@ControllerAdvice
public class MyExceptionHandler {

    /*//处理除零异常
    @ExceptionHandler(value = ArithmeticException.class)
    public ModelAndView arithmeticExceptionHandler(ArithmeticException e) {
        ModelAndView modelAndView = new ModelAndView();
        //设置异常信息
        modelAndView.addObject("msg", e.toString());
        //设置异常处理视图
        modelAndView.setViewName("error");
        return modelAndView;
    }

    //处理空指针异常
    @ExceptionHandler(value = NullPointerException.class)
    public ModelAndView nullPointerExceptionHandler(NullPointerException e) {
        ModelAndView modelAndView = new ModelAndView();
        //设置异常信息
        modelAndView.addObject("msg", e.toString());
        //设置异常处理视图
        modelAndView.setViewName("error");
        return modelAndView;
    }

    //处理数组下标越界异常
    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)
    public ModelAndView arrayIndexOutOfBoundsExceptionHandler(ArrayIndexOutOfBoundsException e) {
        ModelAndView modelAndView = new ModelAndView();
        //设置异常信息
        modelAndView.addObject("msg", e.toString());
        //设置异常处理视图
        modelAndView.setViewName("error");
        return modelAndView;
    }*/

    //处理所有异常
    //@ExceptionHandler(value = Exception.class)
    public ModelAndView exceptionHandler(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        //设置异常信息
        modelAndView.addObject("msg", e.toString());
        //设置异常处理视图
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
