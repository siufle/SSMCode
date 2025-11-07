package com.xq.dao;

import com.xq.pojo.User;

import java.util.List;

public interface UserDao {

    /*public User findUserById(int id);*/

    public List<User> findUser();

}
