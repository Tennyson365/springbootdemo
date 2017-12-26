package com.yoho.springbootdemo.listener;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.listener
 * DateTime: 2017/12/19  16:14
 * Description:测试servlet上下文监听器
 */
@WebListener
@Log4j2
public class TestListener implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        log.info(" ======================================= Listener Init =========================================");
        log.info(servletContextEvent.getServletContext().getServerInfo());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        log.info(" ======================================= Listener Destroy =========================================");
    }
}
