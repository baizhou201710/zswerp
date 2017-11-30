package com.zsw.sys.controller;

import com.alibaba.fastjson.JSON;
import com.zsw.base.Constant;
import com.zsw.base.Result;
import com.zsw.base.ServiceException;
import com.zsw.sys.entity.User;
import com.zsw.sys.service.UserService;
import com.zsw.util.Empty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author baizhou201710@gmail.com
 * description
 * date 2017/11/10 10:12
 */
@Controller("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping(value = "/user")
    public String index(){
        return  "user";
    }

    @RequestMapping(value = "/getAllUser")
    public List<User> getAllUser(){
        System.out.println("HHHH");
        return userService.findAll();
    }

    @RequestMapping("/page")
    @ResponseBody
    public Map<String, Object> page(@RequestParam Map<String, Object> requestMap){

        int limit = Integer.valueOf("" + requestMap.get("limit"));
        int offset = Integer.valueOf("" + requestMap.get("offset"));
        List<User> users = userService.findByPage(limit,offset);

        Map<String, Object> resultMap = new HashMap<String, Object>();
        resultMap.put("status", "success");
        resultMap.put("total", userService.findCount());
        resultMap.put("rows", users);

        return resultMap;
    }

    /**
     * 获取权限
     * @return
     */
    @RequestMapping(value = "/permission",method = RequestMethod.GET)
    @ResponseBody
    public String userRoleAndPermission(){
        Result result = new Result();
        //入库参数校验
/*        if (Empty.isEmpty(id)) {

            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg("id不能为空！");
            return JSON.toJSONString(result);
        }*/
/*
        try {
            result = goodsDetailService.del(id);

        } catch (ServiceException e) {
            e.printStackTrace();
            result.setCode(Constant.RESULT_FAILURE);
            result.setMsg(Constant.SYS_ERR);
        }*/
        return JSON.toJSONString(result);
    }
}
