package com.smart.service;

import com.smart.dao.ClassDao;
import com.smart.dao.UserDao;
import com.smart.domain.Permission;
import com.smart.domain.Role;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserService {
    @Autowired
    private UserDao  userDao;
    private ClassDao  classDao;
    //判断用户登入
    public User login(String loginName,String password){
        return  userDao.findUserLogin(loginName,password);
    }
    //查询所有用户
    public List<User> selectAllUser(){
        return  userDao.findAllUser();
    }
    //通过id查询用户
    public User selectUserById(Integer id){
        return userDao.selectUserById(id);
    }
    //新增一名用户
    public Integer insertUser(User user){
        return userDao.insertUser(user);
    }
    //删除一名用户
    public Integer deleteUser(Integer id){return  userDao.deleteUser(id);}
    //更改用户
    public Integer updateUser(User user){return  userDao.updateUser(user);}
    //通过loginname获取用户
    public User findUserByloginname(String loginname){
        return userDao.findUserByloginname(loginname);
    }
    //通过loginname获取角色
    public Role findRoleByloginname(String loginname){
        return  userDao.findRoleByloginname(loginname);

    }
    //通过loginname获取权限
    public Permission  findPermissionByloginname(String loginname){
        return  userDao.findPermissionByloginname(loginname);
    }


}
