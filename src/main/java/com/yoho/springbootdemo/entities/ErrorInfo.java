package com.yoho.springbootdemo.entities;

import lombok.Data;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo
 * DateTime: 2017/12/15  19:07
 * Description:错误信息实体类
 */


/**
 * *** lombok 使用 ***
 * @Data                提供类所有属性的getter、setter、equals、canEqual、hashCode、toString方法
 * @setter              注解在属性上，为属性提供setting方法
 * @gettet              注解在属性上，为属性提供getting方法
 * @Log4j               注解在类上，为类提供一个属性为log的log4j日志对象
 * @NoArgsConstructor   注解在类上，无参构造
 * AllArgsConstructor   注解在类上，全参构造
 */
@Data
public class ErrorInfo<T> {

//    @Getter(value = AccessLevel.PUBLIC)
    private String msg;
    private String code;
    private T data;
}
