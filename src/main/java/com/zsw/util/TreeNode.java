package com.zsw.util;

import java.io.Serializable;

/**
 * TreeNode
 *
 * @author baizhou
 * @create 2017-12-05 11:25
 */
public class TreeNode implements Serializable {

    private final static long serialVersionUID = 1L;

    private String title;//	必需 节点标题
    private String type="folder";//必需 节点类型 folder 或 item,这里默认为folder
    private TreeAttr attr;//附加数据

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TreeAttr getAttr() {
        return attr;
    }

    public void setAttr(TreeAttr attr) {
        this.attr = attr;
    }
}
