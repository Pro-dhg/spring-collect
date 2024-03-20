package com.spring.demo.aop.response;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ResponseWrapperAdvice
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/20 11:06
 * @Description:
 */
@ControllerAdvice(annotations = RestController.class)
public class ResponseWrapperAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 封装返回结果，这里简单地将原始结果放入一个Map中
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("data", body); // 将原始数据放入"data"键中
        // 可以添加其他通用信息，比如状态码、消息等
        resultMap.put("status", "success");
        resultMap.put("message", "操作成功");

        // 返回封装后的结果
        return resultMap.toString();
    }
}
