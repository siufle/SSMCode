package com.xq;

import com.xq.pojo.Department;
import com.xq.pojo.Product;
import com.xq.service.DepartmentService;
import com.xq.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DynamicDataSourceTest {

    @Autowired
    private ProductService productService;

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void test(){
        Product product = productService.getById(1L);
        System.out.println(product);
        Department department = departmentService.getById(1L);
        System.out.println(department);
    }
}
