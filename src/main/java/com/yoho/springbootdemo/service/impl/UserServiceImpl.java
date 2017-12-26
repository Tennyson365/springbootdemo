package com.yoho.springbootdemo.service.impl;

import com.yoho.springbootdemo.dao.IUserDao;
import com.yoho.springbootdemo.entities.User;
import com.yoho.springbootdemo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.service.impl
 * DateTime: 2017/12/20  19:57
 * Description:手动添加
 */
@Service
//指定默认事务类别（只读）
@Transactional(readOnly = true)
//spring内置缓存
//@CacheConfig
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public Page<User> findAll(int pageNo, int pageSize) throws Exception {
        return userDao.findAll(new PageRequest(pageNo,pageSize,new Sort(Sort.Direction.DESC,"id")));
    }

    @Override
    public Page<User> findByMobile(String code, String mobile, Pageable pageable) throws Exception{
        return null;
    }
}
