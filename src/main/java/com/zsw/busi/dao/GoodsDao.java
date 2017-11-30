package com.zsw.busi.dao;

import com.zsw.base.DaoException;
import com.zsw.busi.entity.Goods;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 15:22
 */
public interface GoodsDao {

    /**
     * 新增
     * @param goods
     */
     void addGoods(Goods goods) throws DaoException;

    /**
     * 修改
     * @param goods
     */

     void  updGoods(Goods goods) throws DaoException;

    /**
     * 删除
     * @param id
     */
     void delGoods(String id) throws DaoException;

    /**
     * 根据goodsNo模糊查询
     * @param map
     * @return
     */
     List<Goods> queryByGoodsNo(String goodsNo) throws DaoException;

    /**
     * 根据型号查询货物信息
     * @param goodsNo
     * @return
     */
     Goods getByGoodsNo(String goodsNo) throws DaoException;

    /**
     * 根据Id查询货物信息
     * @param goodsId
     * @return
     */
     Goods getByGoodsId(String Id) throws DaoException;

    /**
     * 根据goodsId查询该型号库存
     * @param goodsId
     * @return
     * @throws DaoException
     */
     int countStockByGoodsId(String goodsId) throws DaoException;

    /**
     * 多条件查询
     */
    List<Goods> queryByCondition(Map map)throws DaoException;

    /**
     * count多条件查询
     * @param map
     * @return
     * @throws DaoException
     */
    int countByCondition(Map map)throws DaoException;


}
