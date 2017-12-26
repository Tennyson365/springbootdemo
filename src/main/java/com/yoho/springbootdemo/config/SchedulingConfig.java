package com.yoho.springbootdemo.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:springbootdemo
 * Package:com.yoho.springbootdemo.config
 * DateTime: 2017/12/21  17:31
 * Description:手动添加
 */

@Configuration
@EnableScheduling
@Log4j2
public class SchedulingConfig {

    //每5秒执行一次
//    @Scheduled(cron = "0/5 * * * * ?")
//    void scheduled(){
//        log.info("========  Scheduled is running! ========");
//    }
}
