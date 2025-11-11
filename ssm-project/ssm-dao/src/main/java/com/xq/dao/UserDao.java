package com.xq.dao;

import com.xq.pojo.Role;
import com.xq.pojo.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert(("insert into users(email,username,password,phoneNum,status) " +
            "values(#{email},#{username},#{password},#{phoneNum},#{status})"))
    void save(UserInfo userInfo);

    @Results(value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id",
                    many = @Many(select = "com.xq.dao.RoleDao.FindRolesByUserId"))
    })
    @Select("select * from users where id = #{id}")
    UserInfo findById(Integer id);

    @Select("select * from role where id not in (select roleId from users_role where userId = #{id})")
    List<Role> findUserByIdAndAllRole(Integer id);

    @Insert("insert into users_role(userId, roleId) values (#{userId}, #{roleId})")
    void addRoleToUser(@Param("userId") Integer userId,@Param("roleId") Integer id);

    @Select("select * from users where username = #{username} and password = #{password}")
    UserInfo findUser(@Param("username") String username, @Param("password") String password);
}
