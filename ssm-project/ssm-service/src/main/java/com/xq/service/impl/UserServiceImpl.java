package com.xq.service.impl;

import com.xq.dao.UserDao;
import com.xq.pojo.Role;
import com.xq.pojo.UserInfo;
import com.xq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<UserInfo> findAll() {
        return userDao.findAll();
    }

    @Override
    public void save(UserInfo userInfo) {
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public List<Role> findUserByIdAndAllRole(Integer id) {
        return userDao.findUserByIdAndAllRole(id);
    }

    @Override
    public void addRoleToUser(Integer userId, Integer[] ids) {
        for(Integer id : ids) {
            userDao.addRoleToUser(userId,id);
        }
    }

    @Override
    public UserInfo findUser(String username, String password) {
        return userDao.findUser(username,password);
    }
}
