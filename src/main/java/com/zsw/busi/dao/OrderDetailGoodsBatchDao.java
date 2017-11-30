package com.zsw.busi.dao;

import com.zsw.busi.entity.OrderDetailGoodsBatch;

import java.util.List;
import java.util.Map;

/**
 * baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 15:25
 */
public interface OrderDetailGoodsBatchDao {

    /**
     * 新增
     *
     * @param goodsBatch
     */
    void add(OrderDetailGoodsBatch goodsBatch);

    /**
     * 修改
     *
     * @param goodsBatch
     */
    void upd(OrderDetailGoodsBatch goodsBatch);

    /**
     * @param goodsBatch
     */
    void del(OrderDetailGoodsBatch goodsBatch);

    /**
     * 查询
     *
     * @param map
     * @return
     */
    List<OrderDetailGoodsBatch> query(Map map);
}
