/**
 * @since 2008-8-23,下午06:06:10
 */
package com.zsw.framework.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户有权限的菜单数据封装对象。
 * 
 * @author wangliang0103@hotmail.com
 * @date 2012-6-16 下午02:47:50
 * @description
 */
public class SessionMenu {

	private String id;
	private String name;
	private String type; // 菜单类型：1.菜单分类,2.普通菜单，3.按钮，4.外部链接,5菜单树
	private String operate; // 菜单路径，也可以是方法名
	private String iconClass; // 样式名
	private int orderNum; //排序号
	private String description; // 描述
	private String parentId;
	private String code;
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	private List<SessionMenu> children;

	public SessionMenu() {

	}

	public SessionMenu(Object[] obs) {
		this.id = (String) obs[0];
		this.name = (String) obs[1];
		this.type = (String) obs[2];
		this.operate = (String) obs[3];
		this.iconClass = (String) obs[4];
		this.description = (String) obs[5];
		if (obs.length >= 7) {
			this.parentId = (String) obs[6];
		}
		if(obs.length >= 8 && obs[7] !=null){
			this.orderNum = Integer.valueOf(obs[7].toString());
		}
		if(obs.length >= 9 ){
			this.code = (String) obs[8];
		}
	}

	/**
	 * @return the orderNum
	 */
	public int getOrderNum() {
		return orderNum;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIconClass() {
		return iconClass;
	}

	public String getType() {
		return type;
	}

	/**
	 * @return the operate
	 */
	public String getOperate() {
		return operate;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the parentId
	 */
	public String getParentId() {
		return parentId;
	}

	public List<SessionMenu> getChildren() {
		return children;
	}

	public void addChildren(SessionMenu children) {
		if (this.children == null) {
			this.children = new ArrayList<SessionMenu>();
		}
		this.children.add(children);
	}
}