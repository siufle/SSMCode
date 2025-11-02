package com.xq.dao;

import com.xq.pojo.QueryVo;
import com.xq.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserDao {

    public List<User> findAll();

    public User findUserById(int id);

    public void addUser(User user);

    public void updateUser(User user);

    public void deleteUser(int id);

    //模糊搜索
    public List<User> findUserByName(String username);

    public int getTotal();

    //传多个参数
    public List<User> findUSerBySexAndAddress(String sex, String address);

    //通过map集合解决传多个参数的问题
    public List<User> findUSerByMap(Map<String, Object> map);

    //通过集合中的多个id值获取多个User对象
    public List<User> findUserByIds(QueryVo queryVo);
}
