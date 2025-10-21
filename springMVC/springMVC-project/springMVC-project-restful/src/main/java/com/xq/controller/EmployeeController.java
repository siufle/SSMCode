package com.xq.controller;

import com.xq.dao.EmployeeDao;
import com.xq.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Resource
    EmployeeDao employeeDao;

    //查询所有员工信息
    @RequestMapping(value = "employee",method = RequestMethod.GET)
    public String getEmployeeList(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("employees",employees);
        return "employee_list";
    }

    //删除员工信息
    @RequestMapping(value = "employee/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable(value = "id") Integer id){
        employeeDao.delete(id);
        return "redirect:/employee"; //重定向到/employee资源
    }

    //添加员工
    @RequestMapping(value = "employee",method = RequestMethod.POST)
    public String save(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee";
    }

    //回显员工信息
    @RequestMapping(value = "employee/{id}",method = RequestMethod.GET)
    public String getEmployeeById(Model model,@PathVariable("id") Integer id){
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "employee_update";
    }

    //更新员工信息
    @RequestMapping(value = "employee",method = RequestMethod.PUT)
    public String update(Employee employee){
        employeeDao.save(employee);
        return "redirect:/employee"; 
    }
}
