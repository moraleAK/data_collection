package com.el.dc.admin.security;


import com.el.dc.api.database.normal.response.ResponseTO;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CaptchaFilter implements Filter {
    private static final String VERIFICATION_CODE_KEY = "j_verification_code";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String vcPresented = request.getParameter(VERIFICATION_CODE_KEY);
        Object vsInSession = ((HttpServletRequest) request).getSession(true).getAttribute("paVerificationCode");

        if (vsInSession == null) {
            vsInSession = "";
        }

        if (vsInSession.toString().equalsIgnoreCase(vcPresented)) {
            chain.doFilter(request, response);
            return;
        } else {
            ResponseTO e = new ResponseTO();
            ((HttpServletRequest) request).getSession().setAttribute("errorMessage", "验证码不正确。");
            ((HttpServletRequest) request).getSession().setAttribute("useName", request.getParameter("username"));
            ((HttpServletRequest) request).getSession().setAttribute("passWord", request.getParameter("password"));
            ((HttpServletResponse) response).sendRedirect("/pages/login.jsp");
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
}
