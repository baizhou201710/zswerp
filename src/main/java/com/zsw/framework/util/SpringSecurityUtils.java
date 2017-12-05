package com.zsw.framework.util;

import com.zsw.base.ErpConstants;
import com.zsw.framework.entity.SessionUser;
import com.zsw.sys.entity.Role;
import com.zsw.util.Empty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.HashSet;
import java.util.List;
import java.util.Set;



/**
 * 获取用户登录的相关信息工具类
 * 
 * @author wangjianjun
 * 
 */
public class SpringSecurityUtils {

	/** 日志工具类 */
	protected static Logger logger = LoggerFactory.getLogger(SpringSecurityUtils.class);

	private SpringSecurityUtils() {
	}

	/**
	 * 获得当前登陆用户对象
	 * 
	 * @return SecurityUserDetails
	 * */
	@SuppressWarnings("unchecked")
	public static <T extends SessionUser> T getCurrentUser() {
		Authentication authentication = getAuthentication();
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof SessionUser) {
				return (T) principal;
			}
		}
		return null;
	}

	/**
	 * 获得当前登陆用户ID
	 * 
	 * @return String
	 * */
	public static String getCurrentUserId() {
		SessionUser securityUserDetails = getCurrentUser();
		if (!Empty.isEmpty(securityUserDetails)) {
			return getCurrentUser().getId();
		}
		return "";
	}

	/**
	 * 获得当前登陆用户登录名
	 * 
	 * @return String
	 * */
	public static String getCurrentUserRealName() {
		SessionUser securityUserDetails = getCurrentUser();
		if (!Empty.isEmpty(securityUserDetails)) {
			return getCurrentUser().getRealName();
		}
		return "";
	}

	/**
	 * 获得当前登陆用户真实名
	 * 
	 * @return String
	 * */
	public static String getCurrentUserLoginName() {
		Authentication authentication = getAuthentication();
		if (authentication != null && authentication.getPrincipal() != null) {
			return authentication.getName();
		}
		return "";
	}

	/**
	 * 获得当前登陆用户IP
	 * 
	 * @return String
	 * */
	public static String getCurrentUserIp() {
		Authentication authentication = getAuthentication();
		if (authentication != null) {
			Object details = authentication.getDetails();
			if (details instanceof WebAuthenticationDetails) {
				WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;
				return webDetails.getRemoteAddress();
			}
		}
		return "";
	}

	/**
	 * 判断用户是否从Remember Me Cookie自动登录
	 * 
	 * @return
	 */
	public static boolean isRememberMeAuthenticated() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}

		return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
	}

	/**
	 * 更新SecurityContextHolder中的UserDetails信息
	 * 
	 * @return String
	 * */
	public static void saveUserDetailsToContext(UserDetails userDetails) {
		PreAuthenticatedAuthenticationToken authentication = new PreAuthenticatedAuthenticationToken(
				userDetails, userDetails.getPassword(), userDetails.getAuthorities());

		authentication.setDetails(new WebAuthenticationDetails(HttpUtil.getHttpServletRequest()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}

	/**
	 * 删除SecurityContextHolder中的UserDetails信息
	 * 
	 * @return String
	 * */
	public static void clearUserDetailsToContext() {
		SecurityContextHolder.clearContext();
	}

	/**
	 * 判断当前用户是否登录
	 * 
	 * @return 登陆： true 未登录：false
	 * */
	public static boolean isLogin() {
		return !Empty.isEmpty(getAuthentication()) ? true : false;
	}

	/**
	 * 获得Authentication用户权限信息对象
	 * 
	 * @return String
	 * */
	private static Authentication getAuthentication() {
		SecurityContext context = SecurityContextHolder.getContext();
		if (context != null) {
			return context.getAuthentication();
		}
		return null;
	}

	/**
	 * 获得用户所有角色的权限.
	 */
	public static Set<SimpleGrantedAuthority> obtainGrantedAuthorities(Set<Role> roles) {
		Set<SimpleGrantedAuthority> authSet = new HashSet<SimpleGrantedAuthority>();
		for (Role role : roles) {
			authSet.add(new SimpleGrantedAuthority(role.getCode()));
		}
		return authSet;
	}

	/**
	 * 当前用户是否具有管理员权限 当前用户角色与AppConstants.ROLE_ADMIN对比
	 * 
	 * @return
	 */
	public static boolean isAdmin() {
		SessionUser userDetails = SpringSecurityUtils.getCurrentUser();
		if (!Empty.isEmpty(userDetails)) {
			for (String code : userDetails.getRoleCodes()) {
				if (ErpConstants.ROLE_ADMIN.equalsIgnoreCase(code)) {
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * 获取当前用户的角色Id集合
	 * 
	 * @return
	 */
	public static List<String> getRoleIds() {
		SessionUser userDetails = SpringSecurityUtils.getCurrentUser();
		if (!Empty.isEmpty(userDetails)) {
			return userDetails.getRoleIds();
		}
		return null;
	}

}
