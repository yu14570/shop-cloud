package com.yxd.api.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: yxd
 * @create: 2021-10-01
 */
@FeignClient(contextId = "testFeign",name = "eureka-order")
public interface TestFeign {

    @GetMapping("/order/test/testFeign")
    public String testFeignReq();
    @PostMapping("/order/test/objectParamfeign")
    public String objectParamfeign(@RequestParam(name = "index")Integer index);
}
