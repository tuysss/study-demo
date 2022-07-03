package com.tuysss.helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //@Controller + @ResponesBody 向页面返回一些内容而非跳转到某页面
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        //调用业务，接收前端参数
        return "hello!";
    }
}
