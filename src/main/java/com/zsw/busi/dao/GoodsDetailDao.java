package com.zsw.busi.dao;

import com.zsw.base.DaoException;
import com.zsw.busi.entity.Goods;
import com.zsw.busi.entity.GoodsDetail;

import java.util.List;
import java.util.Map;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 15:23
 */
public interface GoodsDetailDao {

    /**
     * 新增
     *
     * @param goodsDetail
     */
    void addGoodsDetail(GoodsDetail goodsDetail) throws DaoException;

    /**
     * 查询
     *
     * @param map
     * @return
     */
    List<Goods> queryGoodsDetail(Map map) throws DaoException;

    /**
     * 修改
     *
     * @param goodsDetail
     */
    void updateGoodsDetail(GoodsDetail goodsDetail) throws DaoException;


    /**
     * 根据goodsId查询GoodsDetail
     *
     * @param goodsId
     * @return
     */
    List<GoodsDetail> getDetailsByGoodsId(String goodsId) throws DaoException;

    /**
     * 根据Id查询GoodsDetail
     *
     * @param id
     * @return
     * @throws DaoException
     */
    GoodsDetail getById(String id) throws DaoException;

    /**
     * 根据Id删除
     * @param id
     * @throws DaoException
     */
    void del(String id) throws DaoException;
}
