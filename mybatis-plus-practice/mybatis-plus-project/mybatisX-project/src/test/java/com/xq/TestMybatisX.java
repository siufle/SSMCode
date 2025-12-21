package com.xq;

import com.xq.mapper.DepartmentMapper;
import com.xq.pojo.Department;
import com.xq.service.DepartmentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestMybatisX {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Test
    public void test() {
        List<Department> departmentList = departmentMapper.selectList(null);
        departmentList.forEach(System.out::println);
    }
}
