package com.xq.dao.impl;

import com.xq.dao.UserDao;

public class UserDaoImpl implements UserDao {
    public UserDaoImpl() {
        System.out.println("无参构造创建UserDaoImpl对象");
    }

    @Override
    public void addUser() {
        System.out.println("新增用户方法被调用");
    }
}
