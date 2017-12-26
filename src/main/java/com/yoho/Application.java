package com.yoho;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:springbootDemo
 * Package:PACKAGE_NAME
 * DateTime: 2017/12/15  10:20
 * Description:手动添加
 */
@SpringBootApplication

/**
 * rest风格controller
 */
@RestController
/**
 * 开启定时任务
 */
//@EnableScheduling
public class Application {

    @RequestMapping("/")
    public String index(){
        return "Hello world";
    }


    public static void main(String [] args){
        SpringApplication.run(Application.class,args);
    }
}
