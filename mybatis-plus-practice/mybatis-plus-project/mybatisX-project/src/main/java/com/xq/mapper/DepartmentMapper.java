package com.xq.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.xq.pojo.Department;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author huang
* @description 针对表【department】的数据库操作Mapper
* @createDate 2025-12-21 17:19:06
* @Entity com.xq.pojo.Department
*/
public interface DepartmentMapper extends BaseMapper<Department> {
    List<Department> selectAllById(@Param("id") Integer id);

    int deleteById(@Param("id") Integer id);

    int updateLocation(@Param("location") String location);
}




