package com.tuysss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController{

    //localhost:8080/Tomcat项目名/h1
    @RequestMapping("/h1")
    public String hello(Model model){
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","Hello SpringMVCAnnotation.");
        //会被视图解析器处理 web-inf/jsp/hello.jsp
        return "hello";
    }
}
