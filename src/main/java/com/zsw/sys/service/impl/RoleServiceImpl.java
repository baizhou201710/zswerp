package com.zsw.sys.service.impl;

import com.zsw.base.DaoException;
import com.zsw.sys.dao.RoleDao;
import com.zsw.sys.entity.Role;
import com.zsw.sys.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author baizhou201710@gmail.com
 * @Description
 * @Date 2017/11/13 16:29
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    public void insert(Role role) {
        roleDao.insert(role);
    }

    /**
     * 根据userId查询Roles
     *
     * @param userId
     * @return
     */
    public List<Role> getRolesByUser(String userId) {
        try {
            return roleDao.getRolesByUser(userId);
        } catch (DaoException e) {
            e.printStackTrace();
        }
        return null;
    }
}
