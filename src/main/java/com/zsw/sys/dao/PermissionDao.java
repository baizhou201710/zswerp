package com.zsw.sys.dao;

import com.zsw.base.DaoException;
import com.zsw.sys.entity.Permission;

import java.util.List;
import java.util.Map;

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

    /**查询用户权限与资源
     * @param userId
     * @return
     */
     List<Permission> getPermissionByUser(Map map) throws DaoException;

    /**
     * 根据id查询
     * @param id
     * @return
     */
     Permission getById(String id) throws DaoException;

    /**
     * 根据id查询下级
     * @param id
     * @return
     */
     List<Permission> getChildById(String id) throws DaoException;

    /**
     * 多条件查询
     * @param map
     * @return
     * @throws DaoException
     */
     List<Permission> getByCondition(Map map) throws DaoException;

    /**
     * 查询记录数
     * @param map
     * @return
     * @throws DaoException
     */
     int countByCondition(Map map)throws DaoException;
}
