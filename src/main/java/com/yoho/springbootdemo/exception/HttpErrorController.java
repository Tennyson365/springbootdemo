package com.yoho.springbootdemo.exception;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:com.yoho.demo.Controller
 * DateTime: 2017/12/15  17:59
 * Description:错误页面处理
 */
@Controller
public class HttpErrorController implements ErrorController {

    private static final String ERROR_PATH = "/error";

    @RequestMapping(ERROR_PATH)
    String handlerError(){
        return "404";
    }

//    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
