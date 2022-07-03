package com.tuysss.controller;
/*
方法二：注解Controller
被Controller注解的类下的所有方法，只要返回值String有对应页面，就可以被视图解析器解析
 */
/*
 @RequestMapping注解用于映射url到控制器类或特定的处理程序方法
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //代表这个类会被Spring接管
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test2(Model model){  //Model是简化版的ModelandView
        model.addAttribute("msg","ControllerTest2");
        return "test";//拼接为：WEB-INF//jsp/hello.jsp
    }

    @RequestMapping("/t3")
    public String test3(Model model){
        model.addAttribute("msg","Another method of Controller...");
        return "test";//拼接为：WEB-INF//jsp/hello.jsp
    }
}
