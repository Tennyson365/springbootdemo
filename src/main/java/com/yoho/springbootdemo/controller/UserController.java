package com.yoho.springbootdemo.controller;

import com.yoho.springbootdemo.entities.User;
import com.yoho.springbootdemo.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.controller
 * DateTime: 2017/12/21  09:13
 * Description:手动添加
 */
@Api(value = "用户接口")
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "测试接口",notes = "测试说明")
//    @RequestMapping("/users")
    @GetMapping("/users")
    Page<User> getUser() throws Exception{
        Page<User> userPage = userService.findAll(0,10);
        return userPage;
    }

}
