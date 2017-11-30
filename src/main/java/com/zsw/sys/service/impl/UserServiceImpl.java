package com.zsw.sys.service.impl;

import com.zsw.base.DaoException;
import com.zsw.base.ServiceException;
import com.zsw.sys.service.UserService;
import com.zsw.sys.dao.UserDao;
import com.zsw.sys.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author baizhou201710@gmail.com
 * @description
 * @date 2017/11/9 17:21
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAllUser();
    }

    public User getByUserName(String userName) {
        return null;
    }

    public List<User> findByName(String name) {
        return null;
    }

    public void insert(User user) {
        userDao.insert(user);
    }

    public List<User> findByPage(int limit, int offset) {
        return userDao.findByPage(limit,offset);
    }

    public Integer findCount() {
        return userDao.countAll();
    }

    /**
     * 根据用户名获取用户、角色和权限信息
     *
     * @param username
     * @return
     * @throws ServiceException
     */
    public User getUserRolePermissionByUserName(String username) throws ServiceException {

        try {
            return userDao.getUserRolePermissionByUserName(username);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
    }
}


