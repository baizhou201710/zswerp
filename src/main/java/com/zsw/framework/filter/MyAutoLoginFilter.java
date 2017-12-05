package com.zsw.framework.filter;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.zsw.framework.util.Encryptor;
import com.zsw.framework.util.HttpUtil;
import com.zsw.framework.util.SpringSecurityUtils;
import com.zsw.util.Empty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.GenericFilterBean;




/**
 * 登录验证的filter, 用于从门户单点进入IdealPortal系统.
 * @author himo.zhang
 */
public class MyAutoLoginFilter extends GenericFilterBean {
	
	private static Logger log = LoggerFactory.getLogger(MyAutoLoginFilter.class);
	
	@Autowired
	private UserDetailsService userDetailsService;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.info("come in AutoLoginFilter...........");
   	 	//过滤掉AJAX的请求
        if (!HttpUtil.isAjaxRequest()) {
	        if(!SpringSecurityUtils.isLogin()){
	    			/*
	    			 * 获取门户系统传递过来的参数实现登录
	    			 */
	    			String ssoName = ((HttpServletRequest) request).getHeader("iv-user");
	    			log.info("come in AutoLoginFilter...........ssoName : "+ssoName);
	    			
	    			if (Empty.isEmpty(ssoName)) {
	    				ssoName = ((HttpServletRequest) request).getRemoteUser();
	    			}
	    			
	    			if (Empty.isEmpty(ssoName)) {
	    				ssoName = ((HttpServletRequest) request).getParameter("sid");
	    			}
	    			log.info("come in AutoLoginFilter2...........ssoName : "+ssoName);
	    			if (!Empty.isEmpty(ssoName)) {
	    				try {
	    					//如果SSO name被base64加密过，则先进行解密
	    					if(Encryptor.isBase64Encode(ssoName)){
	    						ssoName = Encryptor.base64Decode2Str(ssoName);
	    					}
	    					UserDetails userDetails = userDetailsService.loadUserByUsername(ssoName);
	    					if (Empty.isEmpty(userDetails)) {
//	    						LoginLogUtils.addLoginLog(StateConstants.INVALID, LoginLogUtils.LOGINTYPE_PC, LoginLogUtils.AUTHMETHODTYPE_SSO, "用户"+ssoName+"不存在", ssoName+"登陆失败");
	    						throw new UsernameNotFoundException(new MessageFormat("用户 {0} 不存在").format(new Object[] { ssoName }));
	    					}else{
	    						// 获取到门户系统登录用户信息后，手动实现SpringSecurity登录
	    						SpringSecurityUtils.saveUserDetailsToContext(userDetails);
//	    						LoginLogUtils.addLoginLog(StateConstants.INVALID,LoginLogUtils.LOGINTYPE_PC, LoginLogUtils.AUTHMETHODTYPE_SSO, "", ssoName+"登陆成功");
	    					}
	    				} catch (Exception e) {
//	    					LoginLogUtils.addLoginLog(StateConstants.INVALID, LoginLogUtils.LOGINTYPE_PC, LoginLogUtils.AUTHMETHODTYPE_SSO, "用户"+ssoName+"查询出错", ssoName+"登陆失败");
	    					logger.error(new MessageFormat("用户 {0} 查询出错").format(new Object[] { ssoName }));
	    					e.printStackTrace();
	    				}
	    			}
	    		}
        }
        chain.doFilter(request, response);
		return;
	}
}
