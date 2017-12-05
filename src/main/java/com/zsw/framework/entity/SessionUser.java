/**
 * @since 2008-8-23,下午06:06:10
 */
package com.zsw.framework.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zsw.base.ErpConstants;
import com.zsw.sys.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;


/**
 * @author Song.ZH
 * 
 */
public class SessionUser extends User {

	private static final long serialVersionUID = 1L;
	private String id; // 用户对象ID
	private String loginName; // 用户登录名
	private String realName; // 用户真实姓名
	private List<String> roleIds = new ArrayList<String>(); // 角色Id集合；
	private List<String> roleCodes = new ArrayList<String>(); // 角色Id集合；
	private boolean isAdmin; // 是不是系统管理员

	/** 当前用户有权限的菜单，其中KEY为一级菜单（即系统）的编号，VALUE是按树结构保存各系统菜单树数据。 */
	private Map<String, List<SessionMenu>> menus = new HashMap<String, List<SessionMenu>>();

	/**
	 * 
	 * @param username
	 * @param password
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 */
	public SessionUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
				authorities);
	}

	/**
	 * 
	 * @param user
	 * @param enabled
	 * @param accountNonExpired
	 * @param credentialsNonExpired
	 * @param accountNonLocked
	 * @param authorities
	 * @param menus
	 * @param roles
	 * @throws IllegalArgumentException
	 */
	public SessionUser(com.zsw.sys.entity.User user, boolean enabled, boolean accountNonExpired,
					   boolean credentialsNonExpired, boolean accountNonLocked,
					   Collection<? extends GrantedAuthority> authorities, Set<Role> roles)
			throws IllegalArgumentException {
		super(user.getUsername(), user.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
		this.id = user.getId();
		this.loginName = user.getUsername();
		this.realName = user.getRealname();
		if (roles != null) {
			for (Role role : roles) {
				this.roleCodes.add(role.getCode());
				this.roleIds.add(role.getId());
				//判断是否为系统管理员。
				if(ErpConstants.ROLE_ADMIN.equals(role.getCode())){
					this.isAdmin = true;
				}
			}
		}
	}


	public String getId() {
		return id;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getRealName() {
		return realName;
	}
	

	public List<String> getRoleIds() {
		return roleIds;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public Map<String, List<SessionMenu>> getMenus() {
		return menus;
	}

	/**
	 * @return the roleCodes
	 */
	public List<String> getRoleCodes() {
		return roleCodes;
	}
	
	

}