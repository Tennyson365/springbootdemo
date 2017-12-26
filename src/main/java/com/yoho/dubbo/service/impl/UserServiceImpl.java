package com.yoho.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.yoho.dubbo.service.IUserService;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:springbootdemo
 * Package:com.yoho.dubbo.service.impl
 * DateTime: 2017/12/25  15:04
 * Description:手动添加
 */

/**
 * 把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class=""/>
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements IUserService {


}
