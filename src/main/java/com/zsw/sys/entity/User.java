package com.zsw.sys.entity;

import com.zsw.base.BaseEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * author baizhou201710@gmail.com
 * description
 * date 2017/11/9 17:09
 */

public class User extends BaseEntity {


    private String username;

    private String password;

    private String realname;
    private List<Role> roles;



    public User() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    //获取角色名
    public Set<String> getRolesName() {
        List<Role> roles = getRoles();
        Set<String> set = new HashSet<String>();
        for (Role role : roles) {
            set.add(role.getName());
        }
        return set;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                "} " + super.toString();
    }
}
