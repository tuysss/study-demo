package com.tuysss.config;

import com.tuysss.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    /**
     * 注册一个bean，就相当于我们之前写的一个bean标签
     * 该方法的名字，相当于bean标签中的id属性
     *该方法的返回值，相当于bean标签中的class属性
     */
    @Bean
    public User getUser(){
        return new User();
    }
}
