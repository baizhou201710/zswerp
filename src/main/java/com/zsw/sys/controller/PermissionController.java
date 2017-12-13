package com.zsw.sys.controller;

import com.alibaba.fastjson.JSON;
import com.zsw.base.ErpConstants;
import com.zsw.base.Result;
import com.zsw.base.ServiceException;
import com.zsw.framework.entity.SessionUser;
import com.zsw.framework.util.SpringSecurityUtils;
import com.zsw.sys.entity.DictData;
import com.zsw.sys.entity.Permission;
import com.zsw.sys.service.BaseService;
import com.zsw.sys.service.DictDataService;
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
import org.springframework.web.servlet.ModelAndView;

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
    @Resource
    private BaseService baseService;
    @Resource
    private DictDataService dictDataService;

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

    /**
     * 权限与资源树页面
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/treePage")
    @ResponseBody
    public String getTreePage(@RequestParam(value = "id", required = false) String id) {
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

    /**
     * 权限与资源列表
     *
     * @param key
     * @param pageNo
     * @param pageSize
     * @param parentId
     * @return
     */
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
                    for (Permission permission : permissions) {
                        DictData dictData = dictDataService.getByCodeAndVal("state", permission.getState());
                        permission.setState(dictData.getName());
                    }
                    map.put("permissionList", permissions);

                }
            }
            page.put("tolRecord", count);
            if (count % pageSize == 0) {
                page.put("tolPage", count / pageSize);
            } else {
                page.put("tolPage", count / pageSize + 1);
            }

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

    @RequestMapping(value = "/permissionInfo", method = RequestMethod.GET)
    public ModelAndView getInfo(@RequestParam(value = "id", required = false) String id) {
        ModelAndView mav = new ModelAndView("admin/permission/permissionInfo");
        Result result = new Result();
        if (Empty.isEmpty(id)) {
            result.setCode(ErpConstants.RESULT_SUCCESS);
        } else {
            try {
                Permission permission = permissionService.getById(id);
                if (!Empty.isEmpty(permission)) {
                    result.setContent(permission);
                }
                result.setCode(ErpConstants.RESULT_SUCCESS);

            } catch (ServiceException e) {
                e.printStackTrace();
                result.setCode(ErpConstants.RESULT_FAILURE);
                result.setMsg(ErpConstants.SYS_ERR);
            }
        }

        mav.addObject("result", JSON.toJSON(result));
        return mav;
    }

    /**
     * 保存
     *
     * @param id
     * @param parentId
     * @param name
     * @param token
     * @param url
     * @param level
     * @param type
     * @param description
     * @param state
     * @param orderNum
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestParam(value = "id", required = false) String id,
                       @RequestParam(value = "parentId", required = false) String parentId,
                       @RequestParam(value = "name", required = false) String name,
                       @RequestParam(value = "token", required = false) String token,
                       @RequestParam(value = "url", required = false) String url,
                       @RequestParam(value = "level", required = false) String level,
                       @RequestParam(value = "type", required = false) String type,
                       @RequestParam(value = "description", required = false) String description,
                       @RequestParam(value = "state", required = false) String state,
                       @RequestParam(value = "orderNum", required = false) Integer orderNum) {

        Result result = new Result();
        SessionUser sessionUser = SpringSecurityUtils.getCurrentUser();
        Permission permission = new Permission();

        //参数校验
        if (!Empty.isEmpty(parentId)) {
            permission.setParentId(parentId);
        } else if (!"0".equals(id)) {//非顶级节点
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg("上级不能为空！");
            return JSON.toJSONString(result);
        }

        if (!Empty.isEmpty(name)) {
            permission.setName(name);
        } else {
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg("名称不能为空！");
            return JSON.toJSONString(result);
        }
        if (!Empty.isEmpty(url)) {
            permission.setUrl(url);
        } else {
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg("url不能为空！");
            return JSON.toJSONString(result);
        }
        if (!Empty.isEmpty(level)) {
            permission.setLevel(level);
        } else {
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg("层级不能为空！");
            return JSON.toJSONString(result);
        }
        if (!Empty.isEmpty(type)) {
            permission.setType(type);
        } else {
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg("类型不能为空！");
            return JSON.toJSONString(result);
        }
        if (!Empty.isEmpty(state)) {
            permission.setState(state);
        } else {
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg("状态不能为空！");
            return JSON.toJSONString(result);
        }
        if (!Empty.isEmpty(orderNum)) {
            permission.setOrderNum(orderNum);
        } else {
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg("排序号不能为空！");
            return JSON.toJSONString(result);
        }
        if (!Empty.isEmpty(description)) {
            permission.setDescription(description);
        }

        Permission parent = null;
        try {
            if (!"0".equals(parentId)) {//上级非顶级，查询时候存在
                parent = permissionService.getById(parentId);
                if (Empty.isEmpty(parent)) {
                    result.setCode(ErpConstants.RESULT_FAILURE);
                    result.setMsg("上级不存在！");
                    return JSON.toJSONString(result);
                }
            }


            if (!Empty.isEmpty(id)) {//更新
                permission.setId(id);
                permission.setModifier(sessionUser.getLoginName());

                permissionService.update(permission);

            } else {//新增
                permission.setId(baseService.uuid());
                permission.setCreator(sessionUser.getLoginName());

                permissionService.insert(permission);

            }

            result.setCode(ErpConstants.RESULT_SUCCESS);
        } catch (ServiceException e) {
            e.printStackTrace();
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg(ErpConstants.SYS_ERR);
        }
        return JSON.toJSONString(result);
    }

    /**
     * 改变数据状态
     *
     * @param id
     * @param state
     * @return
     */
    @RequestMapping(value = "/updateState", method = RequestMethod.POST)
    @ResponseBody
    public String updState(@RequestParam(value = "id", required = false) String id,
                           @RequestParam(value = "state", required = false) String state) {

        Result result = new Result();
        if (Empty.isEmpty(id)) {
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg("状id不能为空！");
            return JSON.toJSONString(result);
        }
        if (Empty.isEmpty(state)) {
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg("状i态不能为空！");
            return JSON.toJSONString(result);
        } else if (!ErpConstants.STATE_INVAILD.equals(state) && !ErpConstants.STATE_VAILD.equals(state) && !ErpConstants.STATE_DELELED.equals(state)) {
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg("状态参数有误！");
            return JSON.toJSONString(result);
        }

        try {
            permissionService.updateState(state, id);
            result.setCode(ErpConstants.RESULT_SUCCESS);
        } catch (ServiceException e) {
            e.printStackTrace();
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg(ErpConstants.SYS_ERR);
        }
        return JSON.toJSONString(result);
    }

}
