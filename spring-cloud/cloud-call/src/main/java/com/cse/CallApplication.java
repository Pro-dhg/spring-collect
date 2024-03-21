package com.cse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName CallApplication
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/21 16:37
 * @Description:
 */
@EnableFeignClients
@SpringBootApplication
public class CallApplication {
    public static void main(String[] args) {
        SpringApplication.run(CallApplication.class,args);
    }
}
