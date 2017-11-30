package com.zsw.busi.entity;

import com.zsw.base.BaseEntity;

import java.util.List;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 14:56
 */
public class OrderDetail extends BaseEntity {

    /**
     * 出入库编号
     */
    private String orderId;
    /**
     * 货物ID
     */
    private String goodsId;
    /**
     * 该型号进出库数量
     */
    private int quantity;
    /**
     * 出入库价格
     */
    private float price;

    private List<OrderDetailGoodsBatch> orderDetailGoodsBatches;

    public OrderDetail() {
    }

    public OrderDetail(String orderId, String goodsId, int quantity, float price) {
        this.orderId = orderId;
        this.goodsId = goodsId;
        this.quantity = quantity;
        this.price = price;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<OrderDetailGoodsBatch> getOrderDetailGoodsBatches() {
        return orderDetailGoodsBatches;
    }

    public void setOrderDetailGoodsBatches(List<OrderDetailGoodsBatch> orderDetailGoodsBatches) {
        this.orderDetailGoodsBatches = orderDetailGoodsBatches;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "orderId='" + orderId + '\'' +
                ", goodsId='" + goodsId + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                "} " + super.toString();
    }
}
