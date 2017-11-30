package com.zsw.sys.service;

import com.zsw.baseTest.SpringCaseTest;
import com.zsw.sys.entity.Role;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @Author baizhou201710@gmail.com
 * @Description
 * @Date 2017/11/13 16:26
 */
public class RoleServiceTest extends SpringCaseTest {

    @Resource
    private RoleService roleService;
    @Resource
    private BaseService baseService;

    @Test
    public void insertRole(){
        Role role = new Role();
        role.setId(baseService.uuid());
        role.setName("DEFUALT");
        role.setDescription("普通用户");
        role.setCreator("bz");
        System.out.println(role.toString());
        roleService.insert(role);
    }
}
