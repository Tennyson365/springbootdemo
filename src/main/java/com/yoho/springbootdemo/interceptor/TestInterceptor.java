package com.yoho.springbootdemo.interceptor;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.interceptor
 * DateTime: 2017/12/19  16:21
 * Description:测试拦截器
 */
@Log4j2
public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o)
            throws Exception {
        log.info("========================== 在请求处理之前调用（即controller方法调用之前） ==========================");
        //只有返回true才会继续执行下去，返回false取消当前请求
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
                           ModelAndView modelAndView) throws Exception {
        log.info("================ 请求处理之前，视图被渲染之后调用（即controller方法调用之后） =================");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        log.info("====== 在整个请求结束之后调用（即DispatcherServlet渲染了对应视图之后，主要用户清理资源工作） ========");
    }
}
