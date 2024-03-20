package com.spring.demo.aop.web.mvc;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName WebConfig
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/20 10:54
 * @Description:
 *  mvc配置注册拦截器的方法，这里注释掉
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new ActionInterceptor())
//                //拦截所有路径
//                .addPathPatterns("/**");
//    }
}
