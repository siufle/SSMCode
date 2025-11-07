package com.xq.dao;

import com.xq.pojo.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {

    /*@Results(id = "accountMap", value = {
            @Result(id=true,column="id",property="id"),
            @Result(column="uid",property="uid"),
            @Result(column="money",property="money"),
            @Result(column="uid",property="user",
                    *//*@One实现一对一关联查询*//*
                    one = @One(select = "com.xq.dao.UserDao.findUserById", fetchType = FetchType.LAZY))
    })
    @Select("select * from account")
    public List<Account> findAccount();*/

    @Results(id = "accountMap", value = {
            @Result(id=true,column="id",property="id"),
            @Result(column="uid",property="uid"),
            @Result(column="money",property="money")
    })
    @Select("select * from account where uid = #{uId}")
    public List<Account> findAccountByUId(Integer uId);
}
