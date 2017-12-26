package com.yoho.springbootdemo.service;

import com.yoho.springbootdemo.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.service
 * DateTime: 2017/12/20  14:20
 * Description:手动添加
 */
public interface IUserService{

    /**
     * 分页查询
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    public Page<User> findAll(int pageNo, int pageSize) throws Exception;

    /**
     * @param code
     * @param mobile
     * @param pageable
     * @return
     */
    Page<User> findByMobile(String code, String mobile, Pageable pageable)throws Exception;

}
