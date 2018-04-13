package com.el.dc.admin.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

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
