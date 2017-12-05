package com.zsw.sys.controller;

import com.alibaba.fastjson.JSON;
import com.zsw.base.ErpConstants;
import com.zsw.base.Result;
import com.zsw.base.ServiceException;
import com.zsw.framework.entity.SessionUser;
import com.zsw.framework.util.SpringSecurityUtils;
import com.zsw.sys.entity.Permission;
import com.zsw.sys.service.PermissionService;
import com.zsw.util.Empty;
import com.zsw.util.TreeAttr;
import com.zsw.util.TreeNode;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * PermissionController
 * 权限与资源
 *
 * @author baizhou
 * @create 2017-12-04 14:14
 */

@Controller
@RequestMapping(value = "/sys/permission")
public class PermissionController {

    private static final Logger log = Logger.getLogger(PermissionController.class);

    @Resource
    private PermissionService permissionService;

    /**
     * 权限与资源首页
     *
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        return "admin/permission/permissionList";
    }

    /**
     * 权限与资源树
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/tree")
    @ResponseBody
    public String getTree(@RequestParam(value = "id", required = false) String id) {
        Result result = new Result();
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        if (Empty.isEmpty(id)) {//根节点
            id = "0";
        }
        List<Permission> permissions = null;
        try {
            permissions = permissionService.getChildPermission(id);
            if (!Empty.isEmpty(permissions)) {
                //封装成树所需要的数据结构
                for (Permission permission : permissions) {
                    TreeNode treeNode = new TreeNode();
                    treeNode.setTitle(permission.getName());
                    //treeNode.setType("folder");
                    TreeAttr attr = new TreeAttr();
                    attr.setId(permission.getId());
                    treeNode.setAttr(attr);

                    treeNodes.add(treeNode);
                }
                result.setContent(treeNodes);
            }
            result.setCode(ErpConstants.RESULT_SUCCESS);
        } catch (ServiceException e) {
            e.printStackTrace();
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg(ErpConstants.SYS_ERR);
        }

        return JSON.toJSONString(result);
    }

    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public String getList(@RequestParam(value = "key", required = false) String key,
                          @RequestParam(value = "pageNo", required = true) Integer pageNo,
                          @RequestParam(value = "pageSize", required = true) Integer pageSize,
                          @RequestParam(value = "parentId", required = false) String parentId) {

        Result result = new Result();
        Map map = new HashMap();
        if (!Empty.isEmpty(key)) {
            map.put("key", key);
        }
        if (!Empty.isEmpty(parentId)) {
            map.put("parentId", parentId);
        }
        map.put("pageSize", pageSize);
        map.put("limit", (pageNo - 1) * pageSize);

        List<Permission> permissions = null;
        Map res = new HashMap();
        Map page = new HashMap();
        try {
            int count = permissionService.countByCondition(map);
            if (count > 0) {
                permissions = permissionService.getByCondition(map);
                if (!Empty.isEmpty(permissions)) {
                    map.put("permissionList", permissions);

                }
            }
            page.put("tolRecord", count);
            page.put("tolPage", count>0?count / pageSize + 1:0);
            res.put("page", page);
            res.put("permissionList", permissions);
            result.setContent(res);

            result.setCode(ErpConstants.RESULT_SUCCESS);
        } catch (ServiceException e) {
            e.printStackTrace();
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg(ErpConstants.SYS_ERR);
        }
        return JSON.toJSONString(result);
    }
}
