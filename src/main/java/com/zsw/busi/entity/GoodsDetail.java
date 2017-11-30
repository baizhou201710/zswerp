package com.zsw.busi.entity;

import com.zsw.base.BaseEntity;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 14:48
 */
public class GoodsDetail extends BaseEntity {

    /**
     * 货物所对应ID
     */
    private String goodsId;
 ;
    /**
     * 货物批次号
     */
    private String batch;
    /**
     * 库存量
     */
    private int stock;
    /**
     * 入库价格
     */
    private float purchasePrice;
    /**
     * 入库批次号
     */
    private String inStorageBatch;
    /**
     * 备注
     */
    private String description;

    public GoodsDetail() {
    }

    public GoodsDetail(String goodsId, String batch, int stock, float purchasePrice, String inStorageBatch, String description) {
        this.goodsId = goodsId;
        this.stock = stock;
        this.purchasePrice = purchasePrice;
        this.inStorageBatch = inStorageBatch;
        this.description = description;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public String getInStorageBatch() {
        return inStorageBatch;
    }

    public void setInStorageBatch(String inStorageBatch) {
        this.inStorageBatch = inStorageBatch;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "goodsId='" + goodsId + '\'' +
                ", batch='" + batch + '\'' +
                ", stock=" + stock +
                ", purchasePrice=" + purchasePrice +
                ", inStorageBatch='" + inStorageBatch + '\'' +
                ", description='" + description + '\'' +
                "} " + super.toString();
    }
}