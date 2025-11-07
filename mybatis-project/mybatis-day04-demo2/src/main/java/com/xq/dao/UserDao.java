package com.xq.dao;

import com.xq.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    /*将自定义数据类型的属性与表内字段进行一一映射 避免字段不一致导致赋值为空*/
    @Results(id = "userMap", value = {
            /*属性值id表示是否是主键 true为主键*/
            @Result(id = true,column = "id", property = "id"),
            @Result(column = "username", property = "username"),
            @Result(column = "birthday", property = "birthday"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "address", property = "address")
    })
    @Select("select * from user")
    public List<User> findAll();

    /*引用之前定义的Results*/
    @ResultMap("userMap")
    @Insert("insert into user(username,birthday,sex,address) values (#{username},#{birthday},#{sex},#{address})")
    @SelectKey(keyProperty = "id",keyColumn = "id",
            resultType = Integer.class,before = false,statement = {"select last_insert_id()"})
    public void addUser(User user);

}
