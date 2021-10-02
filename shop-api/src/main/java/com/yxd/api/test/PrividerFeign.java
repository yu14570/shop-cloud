package com.yxd.api.test;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "providerFeign", name = "feign-provider")
public interface PrividerFeign {
    @RequestMapping("/pro/testInteger")
    public String testInteger(@RequestParam(name = "timeout")Integer timeout);
}
