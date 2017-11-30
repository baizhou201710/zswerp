package com.zsw.busi.entity;

import com.zsw.base.BaseEntity;

import java.util.List;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/14 14:44
 */
public class Goods extends BaseEntity {

    private String goodsNo;//货物型号
    private String location;//所在仓库位置
    private String description;//备注
    private float salePrice;//建议售价
    private String brand;//品牌
    private String packageType;//封装
    private List<GoodsDetail> goodsDetails;
    private int tolStock;//库存总量
    private String batches;//批次号用"/"拼接

    public String getGoodsNo() {
        return goodsNo;
    }

    public void setGoodsNo(String goodsNo) {
        this.goodsNo = goodsNo;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(float salePrice) {
        this.salePrice = salePrice;
    }



    public List<GoodsDetail> getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(List<GoodsDetail> goodsDetails) {
        this.goodsDetails = goodsDetails;
    }

    public int getTolStock() {
        return tolStock;
    }

    public void setTolStock(int tolStock) {
        this.tolStock = tolStock;
    }

    public Goods() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public String getBatches() {
        return batches;
    }

    public void setBatches(String batches) {
        this.batches = batches;
    }


    public Goods(String goodsNo, String location, String description, float salePrice) {
        this.goodsNo = goodsNo;
        this.location = location;
        this.description = description;
        this.salePrice = salePrice;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsNo='" + goodsNo + '\'' +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", salePrice=" + salePrice +
                ", brand='" + brand + '\'' +
                ", packageType='" + packageType + '\'' +
                ", goodsDetails=" + goodsDetails +
                ", tolStock=" + tolStock +
                "} " + super.toString();
    }
}
