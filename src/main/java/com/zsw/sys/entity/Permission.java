package com.zsw.sys.entity;

import com.zsw.base.BaseEntity;

import java.util.List;

/**
 * Author baizhou201710@gmail.com
 * Description
 * Date 2017/11/13 16:48
 */
public class Permission extends BaseEntity {
    private String name;
    private String token;
    private String url;
    private String description;
    private String type;//0菜单,1链接
    private String level;//菜单级别
    private int orderNum;//排序号
    private String parentId;//父id
    private String roleCode;
    private List<Permission> chlidPermissions;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public List<Permission> getChlidPermissions() {
        return chlidPermissions;
    }

    public void setChlidPermissions(List<Permission> chlidPermissions) {
        this.chlidPermissions = chlidPermissions;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", url='" + url + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                ", level='" + level + '\'' +
                ", orderNum=" + orderNum +
                ", parentId='" + parentId + '\'' +
                "} " + super.toString();
    }
}
