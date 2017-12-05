package com.zsw.framework.entity;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户Session中数据
 * 
 * @author songzh@yeah.net
 * @date Jan 26, 2008 9:25:04 PM
*/
public class SessionData {
	private static final String emdp_sessiondata = "sessiondata";
 
	// 用户信息
	private SessionUser systemUser;

	/**
	 * 
	 * 从session中获取SessionData, 如果不存在，则新建一个，放在session中
	 * 
	 * @param request
	 * @return
	 */
	public synchronized static SessionData getSessionData(HttpServletRequest request) {
		SessionData data = (SessionData) request.getSession().getAttribute(emdp_sessiondata);
		if (data == null) {
			data = new SessionData();
			request.getSession().setAttribute(emdp_sessiondata, data);
		}
		return data;
	}

	/**
	 * 清除session数据
	 */
	public static void clear(HttpServletRequest req) {
		req.getSession().removeAttribute(emdp_sessiondata);
	}

	/**
	 * 判断session中是否已经有session数据，并且用户对象不为空
	 * 
	 * @param request
	 * @return
	 */
	public static boolean isEmpty(HttpServletRequest request) {
		SessionData data = (SessionData) request.getSession(true).getAttribute(emdp_sessiondata);
		return data == null || data.systemUser == null;
	}

	/**
	 * 判断session中是否已经有session数据，并且用户对象不为空,同时对用户的登录名进行验证。
	 * 
	 * @param request
	 * @param loginName
	 *            单点处理中获取的登录名
	 * @return
	 */
	public static boolean isNotLogined(HttpServletRequest request, String loginName) {
		SessionData data = (SessionData) request.getSession().getAttribute(emdp_sessiondata);
		return data == null || data.systemUser == null
				|| !loginName.equals(data.systemUser.getLoginName());
	}

	public SessionUser getCurrentUser() {
		return systemUser;
	}

	/**
	 * 获取当前会话的登录用户对象。
	 * 
	 * @param user
	 */
	public void setCurrentUser(SessionUser systemUser) {
		this.systemUser = systemUser;
	}

}
