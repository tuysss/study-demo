package com.tuysss.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        System.out.println("执行了HelloController=>hello()");
        return "ok";
    }
}
