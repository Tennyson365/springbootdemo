package com.yoho.springbootdemo.config;

import com.yoho.springbootdemo.interceptor.TestInterceptor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.adapter
 * DateTime: 2017/12/19  16:30
 * Description:拦截器配置
 */
@Configuration
@Log4j2
public class AppConfigAdapter extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        log.info("===========================   addInterceptors ===============================");
        /**
         * 注册多个Interceptor    组成拦截链
         * addPathPatterns       用于添加拦截规则
         * excludePathPatterns   用于排除拦截
         */
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");
//        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
