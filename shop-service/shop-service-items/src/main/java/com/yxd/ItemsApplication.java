package com.yxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @description:
 * @author: yxd
 * @create: 2020-11-30
 */

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.yxd.mapper")
@ComponentScan(basePackages = {"com.yxd","org.n3r"})
public class ItemsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ItemsApplication.class,args);
    }
}
