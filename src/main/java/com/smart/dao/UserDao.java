package com.smart.dao;

import com.smart.domain.Permission;
import com.smart.domain.Role;
import com.smart.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    User findUserLogin(@Param("loginname") String loginname, @Param("password") String password);
    List<User> findAllUser();
    Integer insertUser(User user);
    Integer deleteUser(Integer id);
    Integer updateUser(User user);
    User selectUserById(Integer id);
    //通过loginname查询用户
    User findUserByloginname(String loginname);
    //通过loginname查询角色
    Role findRoleByloginname(String loginname);
    //通过loginname查询权限
    Permission findPermissionByloginname(String loginname);
}
