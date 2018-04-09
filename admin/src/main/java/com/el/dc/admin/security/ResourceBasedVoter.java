package com.el.dc.admin.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class ResourceBasedVoter implements AccessDecisionVoter<Object> {
    private static Logger LOG = LoggerFactory.getLogger(ResourceBasedVoter.class);

    public static String SYS_ADMIN = "sysadmin";

    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    public boolean supports(final Class<?> clazz) {
        return true;
    }

    @Override
    public int vote(final Authentication authentication, final Object object,
                    final Collection<ConfigAttribute> attributes) {
        /**
         * 没登录，拒绝
         */
        if (isAnonymous(authentication)) {
            return ACCESS_DENIED;
        }

        /**
         * 系统超级管理员，直接通过
         */
        if (isSysadmin(authentication)) {
            return ACCESS_GRANTED;
        }

        return ACCESS_GRANTED;
    }

    private boolean isSysadmin(final Authentication authentication) {
        UserDetails userDetails = ((UserDetails)authentication.getPrincipal());
        return userDetails.getUsername().equals(SYS_ADMIN);
    }

    private boolean isAnonymous(final Authentication authentication) {
        return authentication instanceof AnonymousAuthenticationToken;
    }
}
