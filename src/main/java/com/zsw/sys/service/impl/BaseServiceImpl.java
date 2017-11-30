package com.zsw.sys.service.impl;

import com.zsw.sys.dao.BaseDao;
import com.zsw.sys.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author baizhou201710@gmail.com
 * @Description
 * @Date 2017/11/13 15:32
 */
@Service
public class BaseServiceImpl implements BaseService {
    @Autowired
    private BaseDao baseDao;
    public String uuid() {
        return baseDao.uuid();
    }
}
