package com.example.shopeespring.config.logger;

import javax.servlet.*;
import java.io.IOException;

public class LogSystem implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException{
        System.out.println("do filter");
        String userId = "";
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy(){

    }
}
