package com.el.dc.admin.security;
import com.el.wc.payment.test.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Rolandz
 * Date: 23/11/2016
 * Time: 1:58 PM
 */
@Component
@Transactional
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {
    private static Logger LOG = LoggerFactory.getLogger(AuthenticationFailureHandlerImpl.class);

    @Value("${payment.test.login.url}")
    private String loginUrl = "/pages/index";

    @Autowired
    private RedisService redisService;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException, ServletException {

        LOG.info("Login ex: {}", exception.getMessage());

        request.getSession().setAttribute("useName", request.getParameter("username"));
        if (exception instanceof AuthenticationException) {
            if ("账户已被冻结".equals(exception.getMessage())) {
                request.getSession().setAttribute("errorMessage", exception.getMessage());
                response.sendRedirect(loginUrl);
            } else if ("临时冻结".equals(exception.getMessage())) {
                request.getSession().setAttribute("errorMessage", "连续五次密码输入错误，账户临时冻结！请于24小时之后再试！");
                response.sendRedirect(loginUrl);
            }

            //连续输错五次账户临时冻结
            else {
                request.getSession().setAttribute("errorMessage", "用户名或密码错误");
                //request.getSession().setAttribute("useName", request.getParameter("username"));
                //request.getSession().setAttribute("passWord", request.getParameter("password"));
                String useName = request.getParameter("username");
                String count = (String) redisService.get(useName + "login");
                int c = 0;
                if (!StringUtils.isEmpty(count)) {
                    c = Integer.parseInt(count);
                }
                if (c < 5) {
                    redisService.addOrUpdateLoginLog(useName + "login", String.valueOf(c + 1));
                } else {
                    request.getSession().setAttribute("errorMessage", "连续五次密码输入错误，账户已临时冻结！请于24小时之后再试！");
                }
                LOG.info("失败次数{}", c + 1);

                response.sendRedirect(loginUrl);
            }
        } else {
            LOG.info("Not auth ex");
            request.getSession().setAttribute("errorMessage", "系统错误。");
        }

    }
}
