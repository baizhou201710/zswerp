package com.zsw.busi.service;

import com.zsw.base.Result;
import com.zsw.base.ServiceException;
import com.zsw.busi.entity.GoodsDetail;

import java.util.Map;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 15:50
 */
public interface GoodsDetailService {

    /**
     * 某型号入库某批次
     *
     * @param goodsDetail
     * @return
     * @throws ServiceException
     */
    Result inStock(GoodsDetail goodsDetail) throws ServiceException;

    /**
     * 出库某批次
     *
     * @param id
     * @param quantity
     * @return
     * @throws ServiceException
     */
    Result outStock(String id, int quantity) throws ServiceException;

    /**
     * 该批次基本资料修改
     *
     * @param detail
     * @return
     * @throws ServiceException
     */
    Result upd(GoodsDetail detail) throws ServiceException;

    /**
     * 库存校正
     * @param detail
     * @return
     * @throws ServiceException
     */
    Result adjustStock(String id, int quantity) throws ServiceException;

    /**
     *
     * @param id
     * @return
     * @throws ServiceException
     */
    Result del(String id) throws ServiceException;

}
