package com.apress.apachetomcat7.chapter8;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author aleksav
 */
public class CharacterEncodingFilter implements Filter {
    Logger logger = Logger.getLogger("test");
    private String encoding;
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encoding");
        System.out.println("Filter initialized.");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        logger.warning("CharacterEncodingFilter.doFilter invoked for requestURI:"+ httpServletRequest.getRequestURI());
        servletResponse.setCharacterEncoding(this.encoding);
        servletRequest.setCharacterEncoding(this.encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        System.out.println("Filter destroyed.");
        //NOOP
    }
}
