package com.cse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProductController
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/21 16:24
 * @Description:
 */
@RestController
public class ProductController {

    @GetMapping("getProductById")
    public String getProductById(Integer productId){
        System.out.println("服务提供者根据id查询商品："+productId);
        return "商品"+productId ;
    }
}
