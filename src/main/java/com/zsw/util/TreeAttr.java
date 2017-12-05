package com.zsw.util;

/**
 * tree.attr
 *
 * @author baizhou
 * @create 2017-12-05 11:29
 */
public class TreeAttr {

    private String classNames;//添加到节点的类名
    private String icon;//自定义图标的 class 名称
    private String id;//

    public String getClassNames() {
        return classNames;
    }

    public void setClassNames(String classNames) {
        this.classNames = classNames;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
