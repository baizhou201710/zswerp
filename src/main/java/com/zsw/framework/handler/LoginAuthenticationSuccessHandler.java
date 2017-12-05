package com.zsw.framework.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zsw.framework.entity.SessionUser;
import com.zsw.framework.util.DateUtil;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;


/**
 * sercurity登录验证成功执行类 SimpleUrlAuthenticationSuccessHandler
 * SavedRequestAwareAuthenticationSuccessHandler
 * */
public class LoginAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(LoginAuthenticationSuccessHandler.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.springframework.security.web.authentication.
	 * SimpleUrlAuthenticationSuccessHandler
	 * #onAuthenticationSuccess(javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse,
	 * org.springframework.security.core.Authentication)
	 */
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		super.onAuthenticationSuccess(request, response, authentication);

		String ip = "";
		SessionUser userDetails = null;
		String result = "success";
		try {
			Object details = authentication.getDetails();
			if (details instanceof WebAuthenticationDetails) {
				WebAuthenticationDetails webDetails = (WebAuthenticationDetails) details;
				ip = webDetails.getRemoteAddress();
			}
			Object principal = authentication.getPrincipal();
			if (principal instanceof SessionUser) {
				userDetails = (SessionUser) principal;
			}

			// Map params = new HashMap();
			// String set = " LAST_LOGIN_TIME=#{login_time} ";
			// String where = "id=#{id}";
			// params.put("login_time",new Date());
			// params.put("id",userDetails.getUserId());
			// userService.updateBySql(set, where, params);

			logger.debug("come in LoginAuthenticationSuccessHandler......用户登录时间修改成功，最后登录时间为："
					+ DateUtil.getCurrentDateTime());
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("用户信息不存在！");
		}
		// I18nUtil.setLocale(request);
		// 这里可以追加开发人员自己的额外处理

		logger.debug("CustomLoginHandler.onAuthenticationSuccess() is called!");
	}
}
