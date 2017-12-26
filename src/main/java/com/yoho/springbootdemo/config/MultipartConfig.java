package com.yoho.springbootdemo.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.config
 * DateTime: 2017/12/19  17:10
 * Description:文件上传文件大小限制配置
 */
@Configuration
public class MultipartConfig {

    @Bean
    MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
        //设置上传单个文件最大限制
        multipartConfigFactory.setMaxFileSize("5MB");
        //设置上传多个文件总和最大限制
        multipartConfigFactory.setMaxRequestSize("5MB");
        //路径地址
//        multipartConfigFactory.setLocation("");

        return multipartConfigFactory.createMultipartConfig();
    }
}
