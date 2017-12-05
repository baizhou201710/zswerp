package com.zsw.framework.handler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zsw.base.Result;
import com.zsw.framework.util.AjaxResponse;
import com.zsw.framework.util.HttpUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;


/**
 * 无访问权限异常处理类
 * 
 * @author 460098508@qq.com
 * @date 2016-6-21 下午05:21:54
 * @description
 */
public class MyAccessDeniedHandler implements AccessDeniedHandler {
	
	// 权限错误跳转页面
	private String errorPage;

	/**
	 * 权限错误跳转页面
	 * 
	 * @param errorPage
	 */
	public void setErrorPage(String errorPage) {
		if ((errorPage != null) && !errorPage.startsWith("/")) {
			throw new IllegalArgumentException("errorPage must begin with '/'");
		}
		this.errorPage = errorPage;
	}

	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		boolean isAjax = HttpUtil.isAjaxRequest();

		if (isAjax) {
			Result result = new Result("1","权限不足");
			AjaxResponse.sendAjaxJSONP((JSONObject)JSON.toJSON(result), response, request);
		} else if (!response.isCommitted()) {
			if (errorPage != null) {
				// Put exception into request scope (perhaps of use to a view)
				request.setAttribute(WebAttributes.ACCESS_DENIED_403, accessDeniedException);

				// Set the 403 status code.
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);

				// forward to error page.
				RequestDispatcher dispatcher = request.getRequestDispatcher(errorPage);
				dispatcher.forward(request, response);
			} else {
				response.sendError(HttpServletResponse.SC_FORBIDDEN, accessDeniedException.getMessage());
			}
		}
		
	}

}
