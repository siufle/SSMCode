package com.xq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xq.pojo.Orders;
import com.xq.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    OrdersService ordersService;

    @RequestMapping("findAll.do")
    public String findAll(@RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                          @RequestParam(value = "size", required = false, defaultValue = "4") Integer size, Model model) {
        PageHelper.startPage(page, size);
        List<Orders> ordersList = ordersService.findAll();
        PageInfo<Orders> pageInfo = new PageInfo<>(ordersList);
        model.addAttribute("pageInfo", pageInfo);
        return "orders-list";
    }

    @RequestMapping("findById.do")
    public String findById(@RequestParam(value = "id") Integer id, Model model) {
        Orders orders = ordersService.findById(id);
        model.addAttribute("orders", orders);
        return "orders-show";
    }
}
