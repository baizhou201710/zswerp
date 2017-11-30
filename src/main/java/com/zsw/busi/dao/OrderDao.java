package com.zsw.busi.dao;

import com.zsw.busi.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 15:24
 */
public interface OrderDao {
    /**
     * 新增
     *
     * @param order
     */
    void addOrder(Order order);

    /**
     * 修改
     *
     * @param order
     */
    void updOrder(Order order);

    /**
     * 删除
     *
     * @param order
     */
    void delOrder(Order order);

    /**
     * 删除
     *
     * @param map
     * @return
     */
    List<Order> queryOrder(Map map);
}
