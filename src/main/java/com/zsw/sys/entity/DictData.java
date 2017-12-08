package com.zsw.sys.entity;

import com.zsw.base.BaseEntity;

/**
 * 数据字典
 *
 * @author baizhou
 * @create 2017-12-06 17:47
 */
public class DictData extends BaseEntity {
    private String parentId;
    private String code;
    private String value;
    private String name;
    private String description;
    private int orderNum;

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
}
