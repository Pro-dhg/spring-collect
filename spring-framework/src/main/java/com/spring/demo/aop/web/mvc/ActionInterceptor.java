package com.spring.demo.aop.web.mvc;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.Objects;

/**
 * @ClassName ActionInterceptor
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/19 17:06
 * @Description:
 *  拦截所有接口
 *
 *  1.可以做参数拦截
 *  2.可以做token过期
 *  3.返回结果格式处理
 */
@Component
public class ActionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token = request.getHeader("Jwt"); // 获取请求头中的token
        if (Objects.isNull(token)){
            System.out.println("不允许无token");
            // 如果没有token或token为空，设置响应状态码为401，并添加适当的消息
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\": \"No token provided\"}");
            return false;
        }
        DecodedJWT decode = null;
        try {
            decode = JWT.decode(token);
        } catch (JWTDecodeException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\": \"Token decryption failed\"}");
            return false;
        }

        if (! decode.getExpiresAt().after(new Date())){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json");
            response.getWriter().write("{\"message\": \"Token expired\"}");
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }


}
