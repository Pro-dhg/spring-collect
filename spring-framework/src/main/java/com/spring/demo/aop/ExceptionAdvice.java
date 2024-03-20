package com.spring.demo.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ClassName ExceptionAdvice
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/19 16:56
 * @Description:
 *  拦截所有异常
 *  这里可以自定义一个返回格式，将结果返回
 */
@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {
    @ResponseBody
    @ExceptionHandler(value = {BindException.class})
    public Object handler(BindException exception) {
        log.warn("捕捉到未被处理的参数异常信息", exception);
        return "业务处理逻辑";
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object global(Exception exception) {
        log.warn("捕捉到未被处理的异常信息", exception);
        return "业务处理逻辑" ;
    }
}
