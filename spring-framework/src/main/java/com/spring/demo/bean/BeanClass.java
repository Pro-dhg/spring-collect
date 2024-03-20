package com.spring.demo.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 * @ClassName BeanClass
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/19 14:42
 * @Description:
 */

@Configuration
public class BeanClass {

    @Bean(value = "TestBean")
    public BeanClass TestBean(){
        return new BeanClass();
    }


    public String test(String value){
        System.out.println("目标方法test被执行入参为:"+value);
        if (!StringUtils.hasLength(value)){
            throw new RuntimeException("value不能为空");
        }
        return value ;
    }
}
