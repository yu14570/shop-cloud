package com.yxd.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: yxd
 * @create: 2021-10-01
 */

@RestController
public class OrderTestController {

    @GetMapping("/order/test/testFeign")
    public String testFeign(){
        System.out.println("testFeign请求进入order服务");
        return "进入order服务，feign调用order服务测试方法";
    }

    @PostMapping("/order/test/objectParamfeign")
    public String objectParamfeign(@RequestParam(name = "index")Integer index){
        System.out.println("objectParamfeign请求进入order服务");
        String ind = index.toString();
        return "进入order服务，测试对象参数，返回index"+ind;
    }
}
