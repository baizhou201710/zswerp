package com.zsw.sys.service.impl;

import com.zsw.base.DaoException;
import com.zsw.base.ErpConstants;
import com.zsw.base.ServiceException;
import com.zsw.sys.service.PermissionService;
import com.zsw.sys.dao.PermissionDao;
import com.zsw.sys.entity.Permission;
import com.zsw.util.Empty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 根据userid查询用户权限与资源
     *
     * @param userId
     * @return
     */
    public List<Permission> getPermissionByUserId(String userId) throws ServiceException {

        Map map = new HashMap();
        List<Permission> permissions=new ArrayList<Permission>();
        try {
            map.put("userId",userId);
            map.put("state", ErpConstants.STATE_VAILD);
            map.put("type","0");
            map.put("level","2");
            //查询二级菜单
            permissions = permissionDao.getPermissionByUser(map);
            if (!Empty.isEmpty(permissions)){
                //查询三级菜单
                for (Permission permission:permissions){
                    map.put("level","3");
                    List<Permission> permissionsLevel2= permissionDao.getPermissionByUser(map);
                    if (!Empty.isEmpty(permissionsLevel2)){
                        permission.setChlidPermissions(permissionsLevel2);

                        //暂时只做两级菜单，为简便而这样书写，后续如有变动再做修改
                    }
                }
            }
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException();

        }
        return permissions;
    }

    /**
     * 根据id获取下级
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    public List<Permission> getChildPermission(String id) throws ServiceException {
        List<Permission> permissions=null;
        try {
            permissions= permissionDao.getChildById(id);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException();
        }
        return permissions;
    }

    /**
     * 多条件查询
     *
     * @param map
     * @return
     * @throws ServiceException
     */
    public List<Permission> getByCondition(Map map) throws ServiceException {
        List<Permission> permissions=null;
        try {
            permissions=permissionDao.getByCondition(map);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException();
        }
        return permissions;
    }

    /**
     * 查询记录数
     *
     * @param map
     * @return
     * @throws ServiceException
     */
    public int countByCondition(Map map) throws ServiceException {
        int count=0;
        try {
            count= permissionDao.countByCondition(map);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException();
        }
        return count;
    }
}
