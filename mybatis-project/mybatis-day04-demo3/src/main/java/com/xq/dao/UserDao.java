package com.xq.dao;

import com.xq.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserDao {

    @Results(id = "userMap", value = {
            @Result(id=true,column="id",property="userId"),
            @Result(column="username",property="userName"),
            @Result(column="sex",property="userSex"),
            @Result(column="address",property="userAddress"),
            @Result(column="birthday",property="userBirthday"),
            @Result(property = "accounts", column = "id",
                    many = @Many(select = "com.xq.dao.AccountDao.findAccountByUId",fetchType = FetchType.LAZY))
    })
    @Select("select * from user")
    public List<User> findAll();

    /*@ResultMap("userMap")
    @Select("select * from user where id = #{id}")
    public User findUserById(Integer id);*/
}
