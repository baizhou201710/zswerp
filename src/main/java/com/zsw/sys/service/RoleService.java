package com.zsw.sys.service;

import com.zsw.sys.entity.Role;

import java.util.List;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/13 16:28
 */
public interface RoleService {
     void insert(Role role);

    /**
     * 根据userId查询Roles
     * @param userId
     * @return
     */
     List<Role> getRolesByUser(String userId);
}
