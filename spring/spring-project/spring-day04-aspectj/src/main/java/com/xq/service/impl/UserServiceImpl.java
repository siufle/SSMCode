package com.xq.service.impl;

import com.xq.service.UserService;

/**
 * 目标类
 */
public class UserServiceImpl implements UserService {
    @Override
    public void findAll() {
        System.out.println("查询用户方法被调用");
    }

    @Override
    public void addUser() {
        //int i = 1/0;
        System.out.println("新增用户方法被实现");
    }

    @Override
    public void updateUser() {
        System.out.println("新增用户方法被实现");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户方法被实现");
    }
}
