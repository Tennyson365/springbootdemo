package com.yoho.springbootdemo.listener;

import lombok.extern.log4j.Log4j2;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.listener
 * DateTime: 2017/12/19  16:18
 * Description:测试session监听器
 */
@WebListener
@Log4j2
public class TestHttpListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info(" ==================================== Session Create =====================================");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info(" ==================================== Session Destroy =====================================");
    }
}
