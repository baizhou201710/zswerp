package com.zsw.framework.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;



/**
 * 登录验证出错处理
 * @author Luxh
 */
public class LoginAuthenticationFailureHandler implements AuthenticationFailureHandler {

	String defaultFailureUrl;
	
	
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException ae)
			throws IOException, ServletException {
		Logger.getLogger(LoginAuthenticationFailureHandler.class).error(ae.getMessage(),ae);
		//根据AuthenticationException异常的类型
		//进行出错业务逻辑处理
		//这里可以追加开发人员自己的额外处理
		request.getSession().setAttribute("SPRING_SECURITY_LAST_EXCEPTION", ae);
//		request.getRequestDispatcher(defaultFailureUrl).forward(request, response);  
		response.sendRedirect(request.getContextPath()+defaultFailureUrl);
	}

	/**
	 * @return the defaultFailureUrl
	 */
	public String getDefaultFailureUrl() {
		return defaultFailureUrl;
	}

	/**
	 * @param defaultFailureUrl the defaultFailureUrl to set
	 */
	public void setDefaultFailureUrl(String defaultFailureUrl) {
		this.defaultFailureUrl = defaultFailureUrl;
	}

}
