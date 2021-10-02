package com.yxd.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description:
 * @author: yxd
 * @create: 2021-10-02
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.yxd.mapper")
@ComponentScan(basePackages = {"com.yxd","org.n3r"})
@EnableFeignClients("com.yxd")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class,args);
    }
}
