package com.el.dc.admin.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestTimeFilter extends OncePerRequestFilter {
    private static Logger LOG = LoggerFactory.getLogger(RequestTimeFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        long begin = System.currentTimeMillis();

        try {
            filterChain.doFilter(request, response);
        }
        catch (Throwable var9) {
            LOG.error("RequestTimingFilter: {}", var9);
            throw new ServletException(var9);
        }
        finally {
            LOG.info("Duration: {}ms for \"{}\"",
                    (System.currentTimeMillis() - begin),
                    request.getRequestURI()
            );
        }
    }
}
