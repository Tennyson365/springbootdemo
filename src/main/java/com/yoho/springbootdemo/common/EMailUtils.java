package com.yoho.springbootdemo.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.util.StringUtils;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:springbootdemo
 * Package:com.yoho.springbootdemo.common
 * DateTime: 2017/12/26  08:56
 * Description:手动添加
 */
public class EMailUtils {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("")
    private String sysFrom;

    public void sendSimpleEmail(String from,String to,String title,String content){
        SimpleMailMessage smm = new SimpleMailMessage();
        //发送者
        if (StringUtils.isEmpty(from)){
            smm.setFrom(sysFrom);
        }else{
            smm.setFrom(from);
        }
        //接收人
        smm.setTo(to);
        //标题
        smm.setSubject(title);
        //内容
        smm.setText(content);

        javaMailSender.send(smm);
    }
}
