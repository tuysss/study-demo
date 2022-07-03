package com.tuysss.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {
    //配置了Swagger的Docket的bean实例
    //源码中没有set方法，所以必须通过构造器构造
    @Bean
    public Docket docket(Environment environment){
        Profiles profiles=Profiles.of("dev","test");
        // 获取项目环境：
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2) //链式编程
                .apiInfo(apiInfo())
                .groupName("tuysss")
                .enable(flag)
                .select()
                //RequestHandlerSelectors: 配置要扫描接口的方式
                //basePackage: 指定要扫描的包
                //any: 扫描全部
                //withClassAnnotation: 扫描类上的注解，参数是一个注解的反射对象
                .apis(RequestHandlerSelectors.basePackage("com.tuysss.swagger.controller"))
                //paths: 过滤的路径
                //.paths(PathSelectors.ant("/tuysss/**"))
                .build();
    }
    //协助开发，多个分组？ -> 多个Docket实例
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }

    //配置Swagger信息，即，apiInfo
    public ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("tuysss", "https://github.com/tuysss", "2862670249@qq.com");

        return new ApiInfo("Tuysss的Swagger接口日志",
                "aaaaaa狗狗",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }

}
