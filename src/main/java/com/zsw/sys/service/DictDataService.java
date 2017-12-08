package com.zsw.sys.service;

import com.zsw.base.ServiceException;
import com.zsw.sys.entity.DictData;

import java.util.List;

/**
 * Created by baizhou on 2017/12/6
 */
public interface DictDataService {

    /**
     * 根据code查询
     *
     * @param code
     * @return
     */
    List<DictData> getByCode(String code) throws ServiceException;

    /**
     * 根据code和value获取dict
     *
     * @param code
     * @param value
     * @return
     * @throws ServiceException
     */
    DictData getByCodeAndVal(String code, String value) throws ServiceException;
}
