package com.smart.shiro;

import com.smart.domain.User;
import com.smart.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.Collections;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    @Qualifier("userService")
    private UserService userService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String loginname= (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        Set<String> roleName= Collections.singleton(userService.findRoleByloginname(loginname).getRoleName());
        Set<String>permissionName= Collections.singleton(userService.findPermissionByloginname(loginname).getPermissionName());
        info.setRoles(roleName);
        info.setStringPermissions(permissionName);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户账号
        String loginname= (String)authenticationToken.getPrincipal();
        User user=userService.findUserByloginname(loginname);
        if(user!=null){
            //将查询到的用户账号和密码存放到 authenticationInfo用于后面的权限判断。第三个参数随便放一个就行了。
            AuthenticationInfo authenticationInfo=new SimpleAuthenticationInfo(user.getLoginName(),user.getPassword(),user.getUsername());
            return authenticationInfo;
        }else{
            return null;
        }
    }
}
