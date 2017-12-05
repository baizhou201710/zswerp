package com.zsw.framework.filter;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


/**
 * sercurity登录过滤器
 * */
public class MyLoginFilter extends UsernamePasswordAuthenticationFilter {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MyLoginFilter.class);
	
	
	public Authentication attemptAuthentication(HttpServletRequest request,
			HttpServletResponse response) throws AuthenticationException {
		logger.debug("come in CustomLoginFilter.....");
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		// if (!request.getMethod().equals("POST")) {
		// throw new AuthenticationServiceException(
		// "Authentication method not supported: "
		// + request.getMethod());
		// }

		String username = obtainUsername(request).trim();
		String password = obtainPassword(request);
		//获取用户输入的下一句答案
//		String answer = obtainAnswer(request);
//		//获取问题Id(即: hashTable的key)
//		Integer questionId = obtainQuestionId(request);

		//这里将原来的UsernamePasswordAuthenticationToken换成我们自定义的CustomAuthenticationToken
//		CustomAuthenticationToken authRequest = new CustomAuthenticationToken(username, password, questionId, answer);
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password);
		//这里就将token传到后续验证环节了
//		setDetails(request, authRequest);
		setDetails(request, authToken);
//		String poem = LoginQuestion.getQuestions().get(questionId);
		// 校验下一句的答案是否正确
//		if (!poem.split("/")[1].equals(answer)) {
//			throw new BadAnswerException("验证问题回答错误!");
//		}
		
		return this.getAuthenticationManager().authenticate(authToken);
//		return this.getAuthenticationManager().authenticate(authRequest);
	}

	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter("username");
		return null == obj ? "" : obj.toString();
	}

	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter("password");
		return null == obj ? "" : obj.toString();
	}
	
	 

}
