package com.zsw.busi.dao;

import com.zsw.busi.entity.OrderDetail;

import java.util.List;
import java.util.Map;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 15:24
 */
public interface OrderDetailDao {

    /**
     * 新增
     *
     * @param detail
     */
    void add(OrderDetail detail);

    /**
     * 修改
     *
     * @param detail
     */
    void upd(OrderDetail detail);

    /**
     * 删除
     *
     * @param orderDetail
     */
    void del(OrderDetail orderDetail);

    /**
     * 查询
     *
     * @param map
     * @return
     */
    List<OrderDetail> query(Map map);
}
