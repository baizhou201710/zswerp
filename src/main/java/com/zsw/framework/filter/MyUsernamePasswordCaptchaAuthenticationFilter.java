package com.zsw.framework.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @ClassName: UsernamePasswordCaptchaAuthenticationFilter
 * @Description: sercurity登录过滤器，校验验证码是否正确
 * @author himo.zhang | mail:ideal_tom@163.com
 * @date 2016-2-25 下午06:55:50
 */
public class MyUsernamePasswordCaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		logger.debug("come in CustomLoginFilter.....");
		// 解决中文诗句的post乱码问题
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String username = obtainUsername(request).trim();
		String password = obtainPassword(request);
		logger.info("MyUsernamePasswordCaptchaAuthenticationFilter***********username===" + username
				+ ";password=" + password);
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username,
				password);
		setDetails(request, authToken);

		return this.getAuthenticationManager().authenticate(authToken);
	}

}