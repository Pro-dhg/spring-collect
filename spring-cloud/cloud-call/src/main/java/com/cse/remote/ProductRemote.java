package com.cse.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName ProductRemote
 * @Author dhg
 * @Version 1.0
 * @Date 2024/3/21 16:38
 * @Description:
 */
@FeignClient(name = "client-product")
public interface ProductRemote {

    @GetMapping("getProductById")
    String getProductById(@RequestParam("productId") Integer productId) ;

}
