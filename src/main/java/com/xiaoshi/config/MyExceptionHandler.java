package com.xiaoshi.config;


import com.alibaba.fastjson.JSONException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author xiaoshi
 * @date 2018-11-16
 */

@ControllerAdvice
@Slf4j
@Order(Ordered.LOWEST_PRECEDENCE-11000)
public class MyExceptionHandler {



    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public UnifyResponse<Object> handleIllegalParamException(MethodArgumentNotValidException e) { // 处理方法参数的异常类型
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        StringBuilder tips = new StringBuilder("参数不合法: ");
        if (errors.size() > 0) {
            for (ObjectError error : errors) {
                tips.append(error.getDefaultMessage()).append("; ");
            }
            //去掉最后一个 ;
            tips.deleteCharAt(tips.length() - 1);
        }

        return UnifyResponse.error(tips.toString());
    }


    @ExceptionHandler(JSONException.class)
    @ResponseBody
    public UnifyResponse<Object> handleJSONException(JSONException be) {
        log.error(be.getMessage(), be);
        return UnifyResponse.error("字符串必须是JSON格式。");
    }



    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public UnifyResponse<Object> exceptionHandle(MissingServletRequestParameterException e) {


        return UnifyResponse.error(e.getParameterName()+"不能为空");
    }


    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public UnifyResponse<Object> exceptionHandle(Throwable e) {

        log.error(e.getMessage(), e);
        if (e.getMessage() == null || "".equals(e.getMessage())) {
            return UnifyResponse.error("服务器内部错误");
        }
        return UnifyResponse.error(e.getMessage());
    }
}
