package com.spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName AopApplication
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/19 14:41
 * @Description:
 */
@SpringBootApplication(scanBasePackages = {"com.spring.*"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
//        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//        BeanClass test = (BeanClass) context.getBean("TestBean");
//        test.test("123123");
    }
}
