package com.yoho.springbootdemo.exception;

import com.yoho.springbootdemo.entities.ErrorInfo;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.hibernate.service.spi.ServiceException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Enumeration;
import java.util.Set;

/**
 * Author: Tennyson
 * E-Mail:wangxing@bailefen.com
 * Project:demo4boot
 * Package:common.handler
 * DateTime: 2017/12/15  17:40
 * Description:全局异常处理
 */
@ControllerAdvice
@RestController
@Log4j2
public class GlobalExceptionHandler /**extends ResponseEntityExceptionHandler */{

    /**
     * 默认异常处理
     * @param request
     * @param e
     * @param model
     * @return 404错误页面
     */
//    @ExceptionHandler(value = Exception.class)
//    String defaultErrorHandler(HttpServletRequest request, Exception e, Model model){
//        log.info("====================== defaultErrorHandler Catch Exception ======================");
//        log(e,request);
//        model.addAttribute("exception","您请求的页面不存在或已被管理员删除！");
//        model.addAttribute("url",request.getRequestURL());
//        return "errorpage/error";
//    }

    /**
     * 自定义返回json的全局异常处理
     *
     * @param request
     * @param e
     * @return json
     */
    @ExceptionHandler(value = UserException.class)
    ErrorInfo<String> jsonErrorHandler(HttpServletRequest request, UserException e){
        log.info("====================== jsonErrorHandler Catch Exception ======================");
        log(e,request);
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setMsg(e.getMessage());
        errorInfo.setCode(e.getCode());
        return errorInfo;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    ErrorInfo<String> missingServletRequestParameterExceptionHandler(HttpServletRequest request,
                                                                     MissingServletRequestParameterException e) {
        log.info("================= missingServletRequestParameterExceptionHandler Catch Exception =================");
        log(e,request);
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode("400");
        errorInfo.setMsg("缺少请求参数！");
        errorInfo.setData(request.getRequestURL().toString());
        return errorInfo;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    ErrorInfo<String> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e,
                                                             HttpServletRequest request) {
        log.info("==================== httpMessageNotReadableExceptionHandler Catch Exception ====================");
        log(e,request);
        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode("400");
        errorInfo.setMsg("参数解析失败！");
        errorInfo.setData(request.getRequestURL().toString());
        return errorInfo;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    ErrorInfo<String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e,
                                                             HttpServletRequest request) {
        log.info("================== methodArgumentNotValidExceptionHandler Catch Exception ==================");
        log(e,request);

        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();

        String field = error.getField();
        String code = error.getDefaultMessage();

        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode(code);
        errorInfo.setMsg("参数验证失败！");
        errorInfo.setData(String.format("s%:%s",field,code));
        return errorInfo;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    ErrorInfo<String> constraintViolationExceptionHandler(ConstraintViolationException e,HttpServletRequest request) {
        log.info("====================== constraintViolationExceptionHandler Catch Exception ======================");

        log(e,request);
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        ConstraintViolation<?> violation = violations.iterator().next();
        String message = violation.getMessage();

        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode("400");
        errorInfo.setMsg("参数验证失败！");
        errorInfo.setData(message);

        return errorInfo;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    ErrorInfo<String> bindExceptionHandler(BindException e,HttpServletRequest request) {
        log.info("====================== bindExceptionHandler Catch Exception ======================");
        log(e,request);

        BindingResult result = e.getBindingResult();
        FieldError error = result.getFieldError();

        String field = error.getField();
        String code = error.getDefaultMessage();

        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode(code);
        errorInfo.setMsg("参数绑定失败！");
        errorInfo.setData(String.format("s%:s%",field,code));
        return errorInfo;
    }

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    ErrorInfo<String> httpRequestMethodNotSupportedExceptionHandler(HttpRequestMethodNotSupportedException e,
                                                                    HttpServletRequest request){
        log.info("============== httpRequestMethodNotSupportedExceptionHandler Catch Exception ===============");
        log(e,request);

        ErrorInfo<String> errorInfo = new ErrorInfo<>();

        errorInfo.setCode("405");
        errorInfo.setMsg("不支持当前请求方法！");
        errorInfo.setData(request.getRequestURL().toString());

        return errorInfo;
    }

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    ErrorInfo<String> httpMediaTypeNotSupportedExceptionHandler(Exception e,
                                                                HttpServletRequest request) {
        log.info("============== httpMediaTypeNotSupportedExceptionHandler Catch Exception ===============");

        log(e,request);

        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode("415");
        errorInfo.setMsg("不支持当前媒体类型！");
        errorInfo.setData(e.getMessage());

        return errorInfo;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServiceException.class)
    ErrorInfo<String> serviceExceptionHandler(ServiceException e,
                                                                HttpServletRequest request) {
        log.info("============== serviceExceptionHandler Catch Exception ===============");
        log(e,request);

        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode("500");
        errorInfo.setMsg("业务逻辑异常，请联系管理员！");
        errorInfo.setData(e.getMessage());

        return errorInfo;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    ErrorInfo<String> exceptionHandler(Exception e,
                                              HttpServletRequest request) {
        log.info("============== exceptionHandler Catch Exception ===============");
        log(e,request);

        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode("500");
        errorInfo.setMsg("通用异常，请联系管理员！");
        errorInfo.setData(e.getMessage());

        return errorInfo;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(DataIntegrityViolationException.class)
    ErrorInfo<String> dataIntegrityViolationExceptionHandler(DataIntegrityViolationException e,
                                       HttpServletRequest request) {
        log.info("============== dataIntegrityViolationExceptionHandler Catch Exception ===============");
        log(e,request);

        ErrorInfo<String> errorInfo = new ErrorInfo<>();
        errorInfo.setCode("500");
        errorInfo.setMsg("操作数据库出现异常，请联系管理员！");
        errorInfo.setData(e.getMessage());

        return errorInfo;
    }

    /**
     * 日志记录
     * @param e
     * @param request
     */
    private void log(Exception e, HttpServletRequest request){
        String name = null;
        log.error("*********************************** Exception Start *************************************");
        log.error(e);
        log.error("");
        Enumeration enumeration = request.getParameterNames();
        if (enumeration.hasMoreElements()){
            log.error("request parameters is:");
            while (enumeration.hasMoreElements()){
                name = enumeration.nextElement().toString();
                log.error( name + "-->" + request.getParameter(name));
            }
        }

        StackTraceElement [] error = e.getStackTrace();
        for (StackTraceElement stackTraceElement:error){
            log.error(stackTraceElement.toString());
        }
        log.error("***********************************  Exception End  *************************************");
    }

}
