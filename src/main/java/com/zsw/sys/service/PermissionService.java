package com.zsw.sys.service;

import com.zsw.base.ServiceException;
import com.zsw.sys.entity.Permission;

import java.util.List;
import java.util.Map;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/13 16:55
 */
public interface PermissionService {

    void insert(Permission permission) throws ServiceException;

    /**
     * 获取所有的权限与角色关系
     * @return
     */
    List<Permission> getAllResAndRole();


    /**
     * 根据userid查询用户权限与资源
     * @param userId
     * @return
     */
    List<Permission> getPermissionByUserId(String userId) throws ServiceException;

    /**
     * 根据id获取下级
     * @param id
     * @return
     * @throws ServiceException
     */
    List<Permission> getChildPermission(String id) throws ServiceException;

    /**
     * 多条件查询
     * @param map
     * @return
     * @throws ServiceException
     */
    List<Permission> getByCondition(Map map) throws ServiceException;

    /**
     * 查询记录数
     * @param map
     * @return
     * @throws ServiceException
     */
    int countByCondition(Map map) throws ServiceException;

    /**
     * 根据id查询
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    Permission getById(String id) throws ServiceException;

    /**
     * 修改
     *
     * @param permission
     * @throws ServiceException
     */
    void update(Permission permission) throws ServiceException;

    /**
     * 彻底删除
     *
     * @param id
     * @throws ServiceException
     */
    void delete(String id) throws ServiceException;

    /**
     * 修改状态
     *
     * @param state
     * @param id
     * @throws ServiceException
     */
    void updateState(String state, String id) throws ServiceException;
}
