package com.tuysss.swagger.controller;

import com.tuysss.swagger.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @RequestMapping(value = "/hello")
    public String hello(){
        return "hello worlds";
    }

    // 只要我们的接口中，返回值中存在实体类，就会被扫描到swagger中
    @GetMapping(value = "/user")
    public User user(){
        return new User();
    }

    @ApiOperation("Hello控制方法")  //控制的api放在方法上，不放在类山
    @PostMapping (value = "hello2")
    public String hello2(@ApiParam("用户名")String username){
        return "hello"+username;
    }

}
