package com.zsw.sys.service.impl;

import com.zsw.base.ServiceException;
import com.zsw.sys.entity.Role;
import com.zsw.sys.entity.User;
import com.zsw.sys.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * ShiroService
 *
 * @author baizhou
 * @create 2017-11-16 15:31
 */

@Service
@Transactional
public class ShiroService extends AuthorizingRealm {

    @Resource
    private UserService userService;

    /**
     * 权限认证
     *
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录时输入的用户名
        String username = (String) principalCollection.fromRealm(getName()).iterator().next();
        //到数据库查是否有此对象
        User user = null;
        try {
            user = userService.getUserRolePermissionByUserName(username);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        //权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (user != null) {
            //用户的角色集合
            info.setRoles(user.getRolesName());
            //用户的角色对应的所有权限，如果只使用角色定义访问权限，下面的四行可以不要
            List<Role> roleList = user.getRoles();
            for (Role role : roleList) {
                info.addStringPermissions(role.getPermissionsName());
            }
        }
        return info;

    }

    /**
     * 身份认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken对象用来存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //查出是否有此用户
        User user = null;
        try {
            user = userService.getUserRolePermissionByUserName(token.getUsername());
        } catch (ServiceException e) {
            e.printStackTrace();
            throw new AuthenticationException();
        }
        if (user != null) {
            //若存在，将此用户存放到登录认证info中
            return new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
        }
        return null;
    }

}

