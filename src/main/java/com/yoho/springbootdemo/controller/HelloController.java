package com.yoho.springbootdemo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo
 * DateTime: 2017/12/15  16:03
 * Description:手动添加
 */
@RestController

public class HelloController {

    @RequestMapping("/hello/{name}")
    String hello(@PathVariable("name")String name,Model model){
//        model.addAttribute("name",name);
        int i = 1/0;
//        throw new UserException("404","test");
        return "hello";
    }

    @RequestMapping("/hello2")
    String hello2(Long id) {
        String string = null;
        string.length();
        return "hello";
    }

    @RequestMapping("/hello3")
    String hello3() {
        String string = null;
        string.length();
        return "hello";
    }
}
