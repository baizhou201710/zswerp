package com.zsw.busi.service;

import com.zsw.base.Result;
import com.zsw.base.ServiceException;
import com.zsw.busi.dao.GoodsDao;
import com.zsw.busi.entity.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 15:47
 */
public interface GoodsService {


    /**
     * 新增商品
     *
     * @param goods
     */
    Result addGoods(Goods goods) throws ServiceException;

    /**
     * 修改商品几倍信息(不包含详细信息)
     *
     * @param goods
     * @return
     * @throws ServiceException
     */
    Result updGoods(Goods goods) throws ServiceException;

    /**
     * 删除某个型号(修改为删除状态)
     *
     * @param goodsId
     * @return
     * @throws ServiceException
     */
    Result del(String goodsId) throws ServiceException;

    /**
     * 根据goodsId查询该型号库存量
     *
     * @param goodsId
     * @return
     * @throws ServiceException
     */
    int countStockByGoodsId(String goodsId) throws ServiceException;

    /**
     * 根据型号模糊查询
     *
     * @param goodNo
     * @return
     * @throws ServiceException
     */
    List<Goods> queryByGoodsNo(String goodNo) throws ServiceException;

    /**
     * 多条件查询
     * @param map
     * @return
     * @throws ServiceException
     */
    List<Goods> queryByCondition(Map map) throws ServiceException;

    /**
     * count多条件查询记录
     * @param map
     * @return
     * @throws ServiceException
     */
    int countByCondition(Map map) throws ServiceException;

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Goods getById(String id) throws ServiceException;

    /**
     * 根据goodsNo查询
     * @param goodsNo
     * @return
     */
    Goods getByGoodsNo(String goodsNo) throws ServiceException;


}
