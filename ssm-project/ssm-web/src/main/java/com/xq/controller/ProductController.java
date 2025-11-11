package com.xq.controller;

import com.xq.pojo.Product;
import com.xq.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("findAll.do")
    public String findAll(Model model){
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "product-list";
    }

    @RequestMapping("save.do")
    public String save(Product product){
        productService.save(product);
        return "redirect:findAll.do";
    }

}
