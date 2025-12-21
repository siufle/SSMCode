package com.xq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xq.pojo.Department;
import com.xq.service.DepartmentService;
import com.xq.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

/**
* @author huang
* @description 针对表【department】的数据库操作Service实现
* @createDate 2025-12-21 17:19:06
*/
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department>
    implements DepartmentService{

}




