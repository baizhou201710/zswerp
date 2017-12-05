package com.zsw.framework.filter;

import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * sercurity登出过滤器
 * */
public class MyLogoutFilter extends LogoutFilter {

	public MyLogoutFilter(String logoutSuccessUrl, LogoutHandler[] handlers) {
		super(logoutSuccessUrl, handlers);
	}

	public MyLogoutFilter(LogoutSuccessHandler logoutSuccessHandler,
			LogoutHandler[] handlers) {
		super(logoutSuccessHandler, handlers);
	}

 
}
