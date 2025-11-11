package com.xq.controller;

import com.xq.pojo.UserInfo;
import com.xq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserService userService;

    @RequestMapping("login.do")
    public String login(String username, String password, HttpServletRequest request){
        UserInfo user = userService.findUser(username,password);
        if(!StringUtils.isEmpty(user)){
            request.getSession().setAttribute("user", user);
            return "redirect:/index.jsp";
        }else{
            return "redirect:/login/login.do";
        }
    }
}
