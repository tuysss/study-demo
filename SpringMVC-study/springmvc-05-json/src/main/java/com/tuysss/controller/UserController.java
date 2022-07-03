package com.tuysss.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tuysss.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller//允许通过类路径自动检测实现类
public class UserController {

    @RequestMapping("/j1")
    @ResponseBody()  //响应体。该注解下的方法不会走视图解析器，会直接返回你真实的东西
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();

        User user=new User("牛劳斯",27,"女");

        String s = mapper.writeValueAsString(user);
        return s;
    }

    @RequestMapping("/j2")
    @ResponseBody
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper=new ObjectMapper();

        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss:SSS'Z'");

        return  mapper.writeValueAsString(sdf.format(date));
    }
}
