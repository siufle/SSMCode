package com.xq.dao;

import com.xq.pojo.Permission;
import com.xq.pojo.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {

    @Results(value = {
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions", column = "id",
                    many = @Many(select = "com.xq.dao.PermissionDao.findPermissionsByRoleId"))
    })
    @Select("select * from role where id in(select roleId from users_role where id = #{userId})")
    List<Role> FindRolesByUserId(Integer userId);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id = #{id}")
    Role findRoleById(Integer id);

    @Select("select * from permission where id not in (select permissionId from role_permission where RoleId = #{id})")
    List<Permission> findRoleByIdAndPermission(Integer id);

    @Insert("insert into role_permission(permissionId, roleId) values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") Integer roleId, @Param("permissionId") Integer id);
}
