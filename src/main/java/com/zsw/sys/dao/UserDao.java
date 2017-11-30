package com.zsw.sys.dao;

import com.zsw.base.DaoException;
import com.zsw.sys.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * author baizhou201710@gmail.com
 * description
 * date 2017/11/10 9:23
 */

public interface UserDao {

    List<User> findAllUser();
    void insert(User user);

    /**
     * mybatis
     *
     * 注解的形式
     * @param limit
     * @param offset
     * @return
     */
    List<User> findByPage(@Param("limit")Integer limit, @Param("offset")Integer offset);

    Integer countAll();

    /**
     * 根据用户名获取用户、角色、权限信息
     * @param username
     * @return
     * @throws DaoException
     */
    User getUserRolePermissionByUserName(String username) throws DaoException;

    User getByUsername(String username);
}
