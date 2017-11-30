package com.zsw.sys.service.impl;

import com.zsw.base.DaoException;
import com.zsw.sys.dao.RoleDao;
import com.zsw.sys.dao.UserDao;
import com.zsw.sys.entity.Role;
import com.zsw.util.Empty;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * MyUserDetails
 *
 * @author baizhou
 * @create 2017-11-30 14:38
 */
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(MyUserDetailsService.class);
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.zsw.sys.entity.User user = userDao.getByUsername(username);
        if (Empty.isEmpty(user)) {
            logger.info(new MessageFormat("用户 {0} 不存在").format(new Object[]{username}));
            throw new UsernameNotFoundException(new MessageFormat("用户 {0} 不存在")
                    .format(new Object[]{username}));
        }

        logger.info("user===" + user.getUsername());
        Set<Role> roles = new HashSet<Role>();
        List<Role> roleList = null;
        try {
            roleList = roleDao.getRolesByUser(user.getId());
        } catch (DaoException e) {
            e.printStackTrace();
        }
        //用户角色
        Set<GrantedAuthority> grantedAuths = new HashSet<GrantedAuthority>();

        /*2016-10-31 wangliang 注释，这个是为测试和开发时权限配置麻烦再添加的，正式运行时需要注释。*/
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_SYS_ADMIN"));
        if (!Empty.isEmpty(roleList)) {
            for (Role role : roleList) {
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_" + role.getCode()));
            }
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        User userDetails = new User(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, grantedAuths);

        return userDetails;
    }
}
