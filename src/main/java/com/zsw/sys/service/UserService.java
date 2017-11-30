package com.zsw.sys.service;

import com.zsw.base.ServiceException;
import com.zsw.sys.entity.User;

import javax.xml.ws.Service;
import java.util.List;

/**
 * author baizhou201710@gmail.com
 * description
 * date 2017/11/9 17:21
 */
public interface UserService {

     List<User> findAll();

     User getByUserName(String userName);

     void insert(User user);
    List<User> findByPage(int limit, int offset);

    Integer findCount();

    /**
     * 根据用户名获取用户、角色和权限信息
     * @param username
     * @return
     * @throws ServiceException
     */
    User getUserRolePermissionByUserName(String username) throws ServiceException;
}
