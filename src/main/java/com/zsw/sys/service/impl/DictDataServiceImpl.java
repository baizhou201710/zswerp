package com.zsw.sys.service.impl;

import com.zsw.base.DaoException;
import com.zsw.base.ServiceException;
import com.zsw.sys.dao.DictDataDao;
import com.zsw.sys.entity.DictData;
import com.zsw.sys.service.DictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 数据字典实现类
 *
 * @author baizhou
 * @create 2017-12-06 18:05
 */
@Service
public class DictDataServiceImpl implements DictDataService {
    /**
     * 根据code查询
     *
     * @param code
     * @return
     */
    @Autowired
    private DictDataDao dictDataDao;

    public List<DictData> getByCode(String code) throws ServiceException {
        List<DictData> dataList = null;
        try {
            dataList = dictDataDao.getByCode(code);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return dataList;
    }

    /**
     * 根据code和value获取dict
     *
     * @param code
     * @param value
     * @return
     * @throws ServiceException
     */
    public DictData getByCodeAndVal(String code, String value) throws ServiceException {
        DictData dictData = null;
        try {
            dictData = dictDataDao.getByCodeAndVal(code, value);
        } catch (DaoException e) {
            e.printStackTrace();
            throw new ServiceException(e);
        }
        return dictData;
    }
}
