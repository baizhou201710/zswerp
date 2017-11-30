package com.zsw.sys.service;

import com.zsw.baseTest.SpringCaseTest;
import com.zsw.sys.entity.Permission;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @Author baizhou201710@gmail.com
 * @Description
 * @Date 2017/11/13 16:57
 */
public class PermissionServiceTest extends SpringCaseTest{
    @Resource
    private PermissionService permissionService;
    @Resource
    private BaseService baseService;

    @Test
    public void insert(){
        Permission permission = new Permission();
        permission.setId(baseService.uuid());
        permission.setToken("87971wefssa34535");
        permission.setCreator("bz");
        permission.setUrl("user/88221");
        /*permission.setRoleId("admin");*/
        permission.setDescription("this is you permission188821");
        System.out.println(permission.toString());
        permissionService.insert(permission);
    }
}
