package com.xq.controller;

import com.xq.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/province")
public class ProvinceController {

    @Autowired
    private ProvinceService provinceService;

    @RequestMapping("/findAll")
    public void findAll(HttpServletResponse response) throws Exception {
        response.setContentType("application/json;charset=utf-8");
        String json_String = provinceService.findAll();
        //向浏览器端响应json数据
        response.getWriter().write(json_String);
    }
}
