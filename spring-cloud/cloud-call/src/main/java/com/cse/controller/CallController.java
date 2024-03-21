package com.cse.controller;

import com.cse.remote.ProductRemote;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName CallController
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/21 16:40
 * @Description:
 */
@RestController
public class CallController {

    @Resource
    private ProductRemote productRemote ;

    @GetMapping("getOrderDetail")
    public String getProductById(Integer productId){
        String productById = productRemote.getProductById(productId);
        System.out.println("消费者从远程获取服务提供的商品信息："+productById);
        return "远程返回的："+productById ;
    }
}
