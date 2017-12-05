package com.zsw.framework.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;


/**
 * sercurity登出执行类
 * */
public class MyLogoutHandler implements LogoutHandler {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MyLogoutHandler.class);
	
	public MyLogoutHandler() {}
	
	
	public void logout(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) {
		
		String ip = "";
		User userDetails = null;
		String result = "success";
		try {
			
			Object details = authentication.getDetails();
			if (details instanceof WebAuthenticationDetails) {
				WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;
				ip = webDetails.getRemoteAddress();
			}
			Object principal = authentication.getPrincipal();
			if (principal instanceof User) {
				userDetails =  (User) principal;
			}
			logger.debug("此处使用log日志工具记录登出信息");
			SecurityContextHolder.clearContext();
		} catch (Exception e) {
			logger.error("用户对象为空!");
		}
		logger.debug("用户已执行登出操作!");
	}

}
