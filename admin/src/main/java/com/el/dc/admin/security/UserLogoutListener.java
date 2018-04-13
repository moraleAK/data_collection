package com.el.dc.admin.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

@Component
public class UserLogoutListener implements ApplicationListener<HttpSessionDestroyedEvent> {
    private static Logger LOG = LoggerFactory.getLogger(UserLogoutListener.class);

    @Override
    public void onApplicationEvent(HttpSessionDestroyedEvent event) {
        SecurityContext ctx = (SecurityContext) event.getSession().getAttribute("SPRING_SECURITY_CONTEXT");
        UserDetailsImpl userDetails = (UserDetailsImpl) ctx.getAuthentication().getPrincipal();
        WebAuthenticationDetails authenticationDetails = (WebAuthenticationDetails) ctx.getAuthentication().getDetails();
    }
}
