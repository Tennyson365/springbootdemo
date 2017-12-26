package com.yoho.springbootdemo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.exception
 * DateTime: 2017/12/15  19:05
 * Description:自定义异常
 */
@Data
@AllArgsConstructor
public class UserException extends Exception{


    String code;
    String msg;

    public UserException(String msg){
        super(msg);
    }

}
