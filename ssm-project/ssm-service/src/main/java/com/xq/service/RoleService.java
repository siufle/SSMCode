package com.xq.service;

import com.xq.pojo.Permission;
import com.xq.pojo.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    Role findRoleById(Integer id);

    List<Permission> findRoleByIdAndPermission(Integer id);

    void addPermissionToRole(Integer roleId, Integer[] ids);
}
