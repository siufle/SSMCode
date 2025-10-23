package com.xq.controller;

import com.xq.exception.CustomizedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("exception")
public class ExceptionController {

    @RequestMapping("demo1")
    public String demo1() {
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomizedException();
        }
        return "success";
    }

    @RequestMapping("demo2")
    public String demo2() {
        int[] arr = null;
        arr[2] = 100;
        return "success";
    }

    @RequestMapping("demo3")
    public String demo3() {
        int[] arr = {1,2,3};
        System.out.println(arr[5]);
        return "success";
    }
}
