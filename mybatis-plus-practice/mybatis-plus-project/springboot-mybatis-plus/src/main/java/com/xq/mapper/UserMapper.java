package com.xq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xq.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.*;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<Map<String,Object>> getUsers();

    Page<User> getPageVO(@Param("page") Page<User> page, @Param("age") Integer age);
}
