package com.zsw.sys.service.impl;

import com.zsw.sys.service.PermissionService;
import com.zsw.sys.dao.PermissionDao;
import com.zsw.sys.entity.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author baizhou201710@gmail.com
 * @Description
 * @Date 2017/11/13 16:55
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;
    public void insert(Permission permission) {
        permissionDao.insert(permission);
    }

    /**
     * 获取所有的权限与角色关系
     *
     * @return
     */
    public List<Permission> getAllResAndRole() {
        return permissionDao.getAllResAndRole();
    }
}
