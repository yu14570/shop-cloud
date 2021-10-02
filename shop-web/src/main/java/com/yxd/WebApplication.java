package com.yxd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @description:
 * @author: yxd
 * @create: 2021-10-01
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.yxd","org.n3r"})
@EnableTransactionManagement
@EnableFeignClients("com.yxd")
@EnableDiscoveryClient
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class,args);
    }
}
