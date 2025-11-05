package com.xq.dao;

import com.xq.pojo.User;

import java.util.List;

public interface UserDao {

    //动态查询
    public List<User> findByCondition(User user);

    //借助where标签实现
    public List<User> findByCondition2(User user);

    //动态修改
    public void updateUserByCondition(User user);

    //动态添加
    public void addUserSelective(User user);

    //动态查询 只依靠一个条件
    public List<User> findByCondition3(User user);

    //批量删除用户 用数组存储多个id
    public void deleteUserByIds(Integer[] ids);

    //新增用户
    public void addUser(User user);
}
