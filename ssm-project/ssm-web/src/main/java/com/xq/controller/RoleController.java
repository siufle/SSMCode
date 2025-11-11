package com.xq.controller;

import com.xq.pojo.Permission;
import com.xq.pojo.Role;
import com.xq.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    RoleService roleService;

    @RequestMapping("findAll.do")
    public String findAll(Model model) {
        List<Role> roleList = roleService.findAll();
        model.addAttribute("roleList", roleList);
        return "role-list";
    }

    @RequestMapping("save.do")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/role/findAll.do";
    }

    @RequestMapping("findRoleByIdAndPermission.do")
    public String findRoleByIdAndPermission(@RequestParam("id") Integer id, Model model) {
        Role role = roleService.findRoleById(id);
        model.addAttribute("role", role);
        List<Permission> permissionList = roleService.findRoleByIdAndPermission(id);
        model.addAttribute("permissionList", permissionList);
        return "role-permission-add";
    }

    @RequestMapping("addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam("roleId") Integer roleId, @RequestParam("ids") Integer[] ids) {
        roleService.addPermissionToRole(roleId,ids);
        return "redirect:/role/findAll.do";
    }
}
