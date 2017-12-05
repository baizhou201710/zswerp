package com.zsw.framework.filter;

import org.apache.log4j.Logger;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义拦截器
 * */
public class MySecurityFilter extends AbstractSecurityInterceptor implements Filter {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MySecurityFilter.class);
	private FilterInvocationSecurityMetadataSource securityMetadataSource;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (logger.isDebugEnabled()) {
			logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - start"); //$NON-NLS-1$
		}
		
//		logger.debug("id : "+request.getParameter("id_"));
		
		FilterInvocation fi = new FilterInvocation(request, response, chain);
		invoke(fi);
//		if (logger.isDebugEnabled()) {
//			logger.debug("doFilter(ServletRequest, ServletResponse, FilterChain) - end"); //$NON-NLS-1$
//		}
		
	}
	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return this.securityMetadataSource;
	}
	public Class<? extends Object> getSecureObjectClass() {
		return FilterInvocation.class;
	}
	public void invoke(FilterInvocation fi) throws IOException, ServletException {
		InterceptorStatusToken token = super.beforeInvocation(fi);
		
		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} finally {
			super.afterInvocation(token, null);
		}
	}
	
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}
	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}
	public void destroy() {
		// 
	}
	public void init(FilterConfig filterconfig) throws ServletException {
		// 
	}
}