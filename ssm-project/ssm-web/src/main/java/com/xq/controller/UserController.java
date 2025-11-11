package com.xq.controller;

import com.xq.pojo.Role;
import com.xq.pojo.UserInfo;
import com.xq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("findAll.do")
    public String findAll(Model model){
        List<UserInfo > userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "user-list";
    }

    @RequestMapping("save.do")
    public String save(UserInfo userInfo){
        userService.save(userInfo);
        return "redirect:/user/findAll.do";
    }

    @RequestMapping("findById.do")
    public String findById(@RequestParam(value = "id") Integer id, Model model){
        UserInfo user = userService.findById(id);
        model.addAttribute("user", user);
        return "user-show";
    }

    @RequestMapping("findUserByIdAndAllRole.do")
    public String findUserByIdAndAllRole(@RequestParam("id") Integer id, Model model){
        UserInfo user = userService.findById(id);
        List<Role> roleList = userService.findUserByIdAndAllRole(id);
        model.addAttribute("user", user);
        model.addAttribute("roleList", roleList);
        return "user-role-add";
    }

    @RequestMapping("addRoleToUser.do")
    public String addRoleToUser(@RequestParam("userId") Integer userId, @RequestParam("ids") Integer[] ids){
        userService.addRoleToUser(userId,ids);
        return "redirect:/user/findAll.do";
    }
}
