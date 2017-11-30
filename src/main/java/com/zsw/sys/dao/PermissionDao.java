package com.zsw.sys.dao;

import com.zsw.sys.entity.Permission;

import java.util.List;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/13 16:51
 */
public interface PermissionDao  {
     void insert(Permission permission);

    /**
     * 获取所有的权限与角色关系
     * @return
     */
     List<Permission> getAllResAndRole();
}
