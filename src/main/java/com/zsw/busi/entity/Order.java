package com.zsw.busi.entity;

import com.zsw.base.BaseEntity;

import java.util.List;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 14:54
 */
public class Order extends BaseEntity {

    /**
     * 出入库编号
     */
    private String orderNo;
    /**
     * 订单类型，0入库，1出库
     */
    private String type;
    /**
     * 出入库总金额
     */
    private float tolAmount;

    private List<OrderDetail> orderDetails;

    public Order() {
    }

    public Order(String orderNo, String type, float tolAmount) {
        this.orderNo = orderNo;
        this.type = type;
        this.tolAmount = tolAmount;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getTolAmount() {
        return tolAmount;
    }

    public void setTolAmount(float tolAmount) {
        this.tolAmount = tolAmount;
    }

    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", type='" + type + '\'' +
                ", tolAmount=" + tolAmount +
                ", orderDetails=" + orderDetails +
                "} " + super.toString();
    }
}
