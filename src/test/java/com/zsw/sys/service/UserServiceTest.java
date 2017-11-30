package com.zsw.sys.service;

import com.zsw.base.ServiceException;
import com.zsw.baseTest.SpringCaseTest;
import com.zsw.sys.entity.User;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @Author baizhou201710@gmail.com
 * @Description
 * @Date 2017/11/10 14:42
 */
public class UserServiceTest extends SpringCaseTest {

    @Resource
    private UserService userService;
    @Resource
    private BaseService baseService;
    //@Test
    public void insert(){
        User user = new User();
        user.setId(baseService.uuid());
        user.setState("0");
        user.setUsername("jimmy");
        user.setCreator("bz");
        user.setPassword("jimmyeatworld");
        System.out.println(user.toString());
        userService.insert(user);
    }

    /**
     * 根据username查询角色权限
     */
    @Test
    public void queryUserRolePermission(){
        try {
            User user = userService.getUserRolePermissionByUserName("bz");
            System.out.println(user.toString());
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
