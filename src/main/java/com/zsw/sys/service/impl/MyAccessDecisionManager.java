package com.zsw.sys.service.impl;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.Iterator;

/**
 * MyAccessDecisionManager
 *
 * @author baizhou
 * @create 2017-11-30 16:43
 */

/**
 * 访问决策器，决定某个用户具有的角色，是否有权限去访问某个资源，做最终的访问控制决定
 * */
public class MyAccessDecisionManager implements AccessDecisionManager {
    /**
     * Logger for this class
     */
    private static final Logger logger = Logger.getLogger(MyAccessDecisionManager.class);

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.security.access.AccessDecisionManager#decide(org.
     * springframework.security.core.Authentication, java.lang.Object,
     * java.util.Collection)
     */
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> configAttributes) throws AccessDeniedException,
            InsufficientAuthenticationException {
        // if (logger.isDebugEnabled()) {
        //			logger.debug("decide(Authentication, Object, Collection<ConfigAttribute>) - start"); //$NON-NLS-1$
        // }
        if (configAttributes == null || configAttributes.isEmpty()) {
            // if (logger.isDebugEnabled()) {
            //				logger.debug("decide(Authentication, Object, Collection<ConfigAttribute>) - end"); //$NON-NLS-1$
            // }
            return;
        }
        logger.info("MyAccessDecisionManager 正在访问的url是：" + object.toString());

        Iterator<ConfigAttribute> ite = configAttributes.iterator();
        while (ite.hasNext()) {
            ConfigAttribute ca = ite.next();
            logger.info("needRole is：" + ca.getAttribute());
            String needRole = ((SecurityConfig) ca).getAttribute();
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                logger.info("判断到needRole是->" + needRole + ",用户的角色是->" + ga.getAuthority());
                if (needRole.equals(ga.getAuthority())) { // ga is user's role.
                    logger.info("->授权数据相匹配");
                    return;
                } else {
                    logger.info("->授权数据不匹配，没有权限");
                }
            }
        }
        throw new AccessDeniedException("没有权限");
    }

    public boolean supports(ConfigAttribute attribute) {
        //
        return true;
    }

    public boolean supports(Class<?> clazz) {
        return true;
    }
}
