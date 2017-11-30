package com.zsw.base;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/13 14:51
 */

import java.io.Serializable;
import java.util.Date;

/**
 * 基类Entity，包含id,creator,createTime,modifier,modifiedTime
 */
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = 1L;
    private String id;
    private String state;
    private String creator;
    private Date createTime;
    private String modifier;
    private Date modifiedTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", creator='" + creator + '\'' +
                ", createTime=" + createTime +
                ", modifier='" + modifier + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
