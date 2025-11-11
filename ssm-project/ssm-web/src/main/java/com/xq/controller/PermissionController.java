package com.xq.controller;

import com.xq.pojo.Permission;
import com.xq.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @RequestMapping("findAll.do")
    public String findAll(Model model) {
        List<Permission> permissionList = permissionService.findAll();
        model.addAttribute("permissionList", permissionList);
        return "permission-list";
    }

    @RequestMapping("save.do")
    public String save(Permission permission) {
        permissionService.save(permission);
        return "redirect:/permission/findAll.do";
    }
}
