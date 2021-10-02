package com.yxd.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger2 {

    //http:/localhost:8088/swagger-ui.html 原路径
    //http:/localhost:8088/doc.html
    //配置swagger2核心配置 docket
    @Bean
    public Docket creatRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)  //指定api类型swagger2
                .apiInfo(apiInfo())                     //用于定义api文档汇总信息
                .select()                               //指定controller包
                .apis(RequestHandlerSelectors.basePackage("com.yxd.controller"))
                .paths(PathSelectors.any())             //所有controller
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("天天吃货 电商平台接口api")
                .contact(new Contact("yxd","https://www,yxd.com","yxd@yxd.com"))
                .description("提供的文档")
                .version("1.0")
                .termsOfServiceUrl("https://yxd.com")
                .build();
    }
}