package com.tuysss.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//在template目录下的所有页面，只能通过controller跳转
//需要模板引擎thymeleaf的依赖
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String index(Model model){
        model.addAttribute("msg","<h1>hello,spring</h1>");

        model.addAttribute("users", Arrays.asList("Clare","Sally","Rooney"));
        return "test";
    }

}































