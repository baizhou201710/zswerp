package com.zsw.sys.controller;

import com.alibaba.fastjson.JSON;
import com.zsw.base.ErpConstants;
import com.zsw.base.Result;
import com.zsw.base.ServiceException;
import com.zsw.sys.entity.DictData;
import com.zsw.sys.service.DictDataService;
import com.zsw.util.Empty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * 数据字典Controller
 *
 * @author baizhou
 * @create 2017-12-06 18:09
 */
@Controller
@RequestMapping(value = "/sys/dict")
public class DictDataController {

    @Resource
    private DictDataService dictDataService;

    /**
     * 根据code,value获取dict
     *
     * @return
     */
    @RequestMapping(value = "/getDict", method = RequestMethod.POST)
    @ResponseBody
    public String getDictByCode(@RequestParam(value = "code", required = true) String code,
                                @RequestParam(value = "value", required = false) String value) {
        Result result = new Result();
        DictData dictData = null;
        List<DictData> list = null;
        if (Empty.isEmpty(code)) {
            result.setCode(ErpConstants.RESULT_SUCCESS);
            result.setMsg("code不能为空！");
            return JSON.toJSONString(result);
        }
        try {
            if (Empty.isEmpty(value)) {
                list = dictDataService.getByCode(code);
                if (!Empty.isEmpty(list)) {
                    result.setContent(list);
                }

            } else {
                dictData = dictDataService.getByCodeAndVal(code, value);
                if (!Empty.isEmpty(dictData)) {
                    result.setContent(dictData);
                }
            }
            result.setCode(ErpConstants.RESULT_SUCCESS);
        } catch (ServiceException e) {
            e.printStackTrace();
            result.setCode(ErpConstants.RESULT_FAILURE);
            result.setMsg(ErpConstants.SYS_ERR);
        }
        return JSON.toJSONString(result);
    }
}
