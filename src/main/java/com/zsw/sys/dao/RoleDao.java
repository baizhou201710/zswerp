package com.zsw.sys.dao;

import com.zsw.base.DaoException;
import com.zsw.sys.entity.Role;

import java.util.List;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/13 16:27
 */
public interface RoleDao {
    public void insert(Role role);

    List<Role> getRolesByUser(String userId) throws DaoException;
}
