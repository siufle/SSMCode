package com.xq.dao;

import com.xq.pojo.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProvinceDao {

    @Select("select * from province")
    List<Province> findAll();
}
