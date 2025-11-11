package com.xq.service;

import com.xq.pojo.Role;
import com.xq.pojo.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> findAll();

    void save(UserInfo userInfo);

    UserInfo findById(Integer id);

    List<Role> findUserByIdAndAllRole(Integer id);

    void addRoleToUser(Integer userId, Integer[] ids);

    UserInfo findUser(String username, String password);
}
