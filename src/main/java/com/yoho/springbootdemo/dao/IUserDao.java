package com.yoho.springbootdemo.dao;


import com.yoho.springbootdemo.entities.User;
import common.baseDao.IBaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.dao
 * DateTime: 2017/12/21  08:59
 * Description:手动添加
 */
@Repository
public interface IUserDao extends IBaseRepository<User,Integer> {


    /**
     * 分页获取所有用户信息
     * @param pageable
     * @return
     */
    @Override
    Page<User> findAll(Pageable pageable);

    /**
     * @param code
     * @param mobile
     * @param pageable
     * @return
     */
    Page<User> findByMobile(String code, String mobile, Pageable pageable);
}
