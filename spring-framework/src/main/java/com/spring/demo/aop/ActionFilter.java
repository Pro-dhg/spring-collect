package com.spring.demo.aop;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName ActionFilter
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/19 17:20
 * @Description:
 *  不会主动注册到bean中，需要手动注入，使用@Bean
 *
 * HTTP请求修改：在Servlet层面上对进入的HTTP请求进行修改，比如增加、修改、删除请求头部信息。
 * HTTP响应修改：在返回给客户端之前对HTTP响应进行修改。
 * 跨域资源共享（CORS）：添加CORS（Cross-Origin Resource Sharing）头信息，允许或限制跨域请求。
 * 安全性：实施如同拦截器的身份验证和授权控制，但在Servlet更早的阶段执行。
 * 编码设置：确保请求和响应采用正确的字符编码。
 * 资源管理：如在请求处理前后对资源进行分配和释放。
 * 压缩：对响应体数据进行压缩以降低带宽消耗。
 * 缓存控制：实现HTTP缓存逻辑，如ETags或者设置过期头部信息。
 *
 */
@Component
public class ActionFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setStatus(HttpStatus.OK.value());
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json; charset=utf-8");

        filterChain.doFilter(servletRequest, response);
    }


    @Override
    public void destroy() {

    }
}
