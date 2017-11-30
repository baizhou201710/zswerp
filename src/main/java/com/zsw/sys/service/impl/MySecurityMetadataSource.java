package com.zsw.sys.service.impl;

import com.sun.deploy.association.utility.AppConstants;
import com.zsw.base.Constant;
import com.zsw.sys.entity.Permission;
import com.zsw.sys.service.PermissionService;
import com.zsw.util.Empty;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * MySecurityMetadataSource
 *
 * @author baizhou
 * @create 2017-11-30 16:37
 */

/*  *  
  * 最核心的地方，就是提供某个资源对应的权限定义，即getAttributes方法返回的结果。 
  * 注意，我例子中使用的是AntUrlPathMatcher这个path matcher来检查URL是否与资源定义匹配， 
  * 事实上你还要用正则的方式来匹配，或者自己实现一个matcher。  *  
  * 此类在初始化时，应该取到所有资源及其对应角色的定义  *  
  * 说明：对于方法的spring注入，只能在方法和成员变量里注入， 
  * 如果一个类要进行实例化的时候，不能注入对象和操作对象，  
 * 所以在构造函数里不能进行操作注入的数据。
 **/
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource, InitializingBean {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(MyUserDetailsService.class);

    private Map<String, List<String>> resourceMap = null;

    @Resource
    private PermissionService permissionService;

    public MySecurityMetadataSource() {
        super();
    }

    /**
     * 加载所有资源与角色配置信息
     */
    @SuppressWarnings({"unchecked", "null"})
    public void afterPropertiesSet() throws Exception {
        resourceMap = new HashMap<String, List<String>>();
        try {
            // 按资源路径排序查询所有资源与角色的关联
            List<Permission> res = permissionService.getAllResAndRole();
            String code = null;
            List<String> atts = null;
            for (Permission permission : res) {
                String rv = permission.getUrl();
                String roleCode = permission.getRoleCode();
                if (Empty.isEmpty(roleCode)) { // 角色为空时，直接跳过。
                    continue;
                }
                if (code == null || !code.equals(rv)) { // 资源变化后，进入新资源授权。
                    code = rv;
                    atts = new ArrayList<String>();
                    resourceMap.put(code, atts);
                }
                // 添加角色到授权中。
                String s = "ROLE_" + roleCode;
                if (!atts.contains(s)) {
                    atts.add(s);
                }
            }

			/*
             * 添加系统角色授权,即系统管理员角色可以访问所有资源，
			 * 如果系统有特殊要求，系统管理员角色也需要手动配置权限，则这里需要注释
			 */
            atts = new ArrayList<String>();
            atts.add("ROLE_" + Constant.ROLE_ADMIN);
            resourceMap.put("/**", atts);

        } catch (Exception e) {
            logger.warn("加载系统资源权限信息时出错！", e);
        }

    }

    // 对请求url进行简单处理后，然后与资源表中的授权掩码匹配，查找出匹配的角色，然后以角色名new出的SecurityConfig数组，以此返回给系统进行授权。
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

        // guess object is a URL.
        FilterInvocation filterInvocation = (FilterInvocation) object;
        HttpServletRequest request = filterInvocation.getHttpRequest();

        List<ConfigAttribute> result = new ArrayList<ConfigAttribute>();
        List<String> roleCodes = new ArrayList<String>();
        // 根据请求的URL获取有权限的角色编号。
        for (String resURL : resourceMap.keySet()) {
            RequestMatcher requestMatcher = new AntPathRequestMatcher(resURL);
            if (requestMatcher.matches(request)) {
				/*
				 * if(tempCode == null || tempCode.length() < resURL.length()){
				 * tempCode = resURL; roleCodes = resourceMap.get(resURL); }
				 */
                for (String code : resourceMap.get(resURL)) {
                    if (!roleCodes.contains(code)) {
                        roleCodes.add(code);
                    }
                }
            }
        }
        logger.info("MySecurityMetadataSource getRequestUrl =====" + filterInvocation.getRequestUrl());
        logger.info(roleCodes);
        // 根据比对的角色编号创建权限
        if (roleCodes.isEmpty()) {
            // 如果没有角色，则设置为系统管理员可以访问
            // result.add(new SecurityConfig(AppConstants.ROLE_ADMIN));
        } else {
            for (String roleCode : roleCodes) {
                result.add(new SecurityConfig(roleCode));
            }
        }

        return result;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }

    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;

    }
}