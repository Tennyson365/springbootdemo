package com.yoho.springbootdemo.filter;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.filter
 * DateTime: 2017/12/19  16:09
 * Description:测试过滤器
 */
@WebFilter(filterName = "testFilter",urlPatterns = "/*")
@Log4j2
public class TestFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info(" ======================================= Filter Init =========================================");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        log.info(" ======================================= Filter doFilter =========================================");
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {
        log.info(" ======================================= Filter Destroy =========================================");
    }
}
