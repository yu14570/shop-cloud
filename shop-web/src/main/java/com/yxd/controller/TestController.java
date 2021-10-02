package com.yxd.controller;

import com.yxd.api.test.PrividerFeign;
import com.yxd.api.test.TestFeign;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "测试相关", tags = {"测试相关的api接口"})
@RestController("/consumer")
public class TestController {

    @Autowired
    public TestFeign testFeign;
    @Autowired
    public PrividerFeign prividerFeign;

    @GetMapping("/test")
    public String test(){
        String result = "test test test";
//        String result = restTemplate.getForObject("http://localhost:8089/ordertest",String.class);
        return result;
    }

    @ApiOperation(value = "测试Feign调用服务", notes = "测试Feign调用服务", httpMethod = "GET")
    @GetMapping("/test/feign")
    public String testFeign(){
        String result = "feign测试调用order服务";
        result = testFeign.testFeignReq();
        return result;
    }

    @GetMapping("/test/objectParamfeign")
    @ApiOperation(value = "测试Feign调用服务", notes = "integer参数", httpMethod = "GET")
    public String objectParamfeign(){
        String result = "feign测试调用order服务";
        Integer index = new Integer(12);
        System.out.println("fegin请求order服务objectParamfeign，参数为index:"+index.toString());
        result = testFeign.objectParamfeign(index);
        return result;
    }


    @GetMapping("/pro/testInteger")
    public String testInteger(){
        String result = "feign测试调用order服务";
        Integer index = new Integer(12);
        result = prividerFeign.testInteger(index);
        return result;
    }

}
