package com.xq;

import com.xq.pojo.Department;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ActiveRecordTest {

    @Test
    public void testInsert() {
        Department department = new Department();
        department.setDeptName("人事部");
        department.setLocation("北京");
        department.insert();
    }

    @Test
    public void testSelect() {
        Department department = new Department();
        List<Department> departmentList = department.selectAll();
        departmentList.forEach(System.out::println);
    }
}
