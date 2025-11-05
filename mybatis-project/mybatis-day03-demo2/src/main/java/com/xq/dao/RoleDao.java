package com.xq.dao;

import com.xq.pojo.Role;

import java.util.List;

public interface RoleDao {

    //查找角色以及其对应的用户信息
    public List<Role> findRole();
}
