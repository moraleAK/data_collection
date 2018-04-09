package com.el.dc.admin.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

/**
 * User: Rolandz
 * Date: 22/11/2016
 * Time: 8:23 PM
 */
@Component
public class UserDetailServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        try {
//            TestAdmin testAdmin = testAdminDao.loadTestAdminByName(username);
//            if (testAdmin != null) {
//
//                UserDetailsImpl details = new UserDetailsImpl();
//                details.setAccountNonExpired(true);
//                details.setAccountNonLocked(true);
//                details.setEnabled(true);
//                details.setCredentialsNonExpired(true);
//                details.setUsername(testAdmin.getLoginName());
//                details.setPassword(testAdmin.getPassword());
//                details.setId(testAdmin.getId());
//                return details;
//            }
//            return null;
//        } catch (NoResultException e) {
//            throw new UsernameNotFoundException(e.getMessage());
//        }
        return new UserDetailsImpl();
    }
}
