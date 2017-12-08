package com.zsw.sys.dao;

import com.zsw.base.DaoException;
import com.zsw.sys.entity.DictData;

import java.util.List;

/**
 * Created by baizhou on 2017/12/6
 */
public interface DictDataDao {

    List<DictData> getByCode(String code) throws DaoException;

    DictData getByCodeAndVal(String code, String value) throws DaoException;
}
