package com.spring.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HoldController
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/19 17:24
 * @Description:
 */
@RestController
public class HoldController {

    @PostMapping("/hold")
    public String getName(){
        return "duanduan" ;
    }
}
