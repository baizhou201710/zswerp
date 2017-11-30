package com.zsw.busi.entity;

import com.zsw.base.BaseEntity;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 14:59
 */
public class OrderDetailGoodsBatch extends BaseEntity{

    /**
     * 出入库详情ID
     */
    private String orderDetailId;
    /**
     * 货物批次号
     */
    private String batch;
    /**
     * 该批次号出入库数量
     */
    private int amount;

    public OrderDetailGoodsBatch() {
    }

    public OrderDetailGoodsBatch(String orderDetailId, String batch, int amount) {
        this.orderDetailId = orderDetailId;
        this.batch = batch;
        this.amount = amount;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderDetailGoodsBatch{" +
                "orderDetailId='" + orderDetailId + '\'' +
                ", batch='" + batch + '\'' +
                ", amount=" + amount +
                "} " + super.toString();
    }
}
