package com.xq.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xq.mapper.DepartmentMapper;
import com.xq.pojo.Department;
import com.xq.service.DepartmentService;
import org.springframework.stereotype.Service;

@Service
@DS("slave_1")
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements DepartmentService {
}
