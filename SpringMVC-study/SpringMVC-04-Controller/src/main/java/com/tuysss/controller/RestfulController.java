package com.tuysss.controller;
/*
原来的url：http://localhost:8080/SpringMVC/add?a=1&b=2
@PathVariable注解让方法的参数值绑定到一个URI模板变量上
优点：
1. restful风格可以实现：相同的url，根据request请求的方法不同，后端达到不同的效果->实现url的复用
2. 安全。url不会直接暴露参数
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestfulController {

    //@RequestMapping(value = "/add/{a}/{b}",method = RequestMethod.POST)
    @PostMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a, @PathVariable int b, Model model){
        int res=a+b;
        model.addAttribute("msg","结果为"+res);
        return "test";
    }

    @GetMapping("/add/{a}/{b}")
    public String test2(@PathVariable String a, @PathVariable String b, Model model){
        String res=a+b;
        model.addAttribute("msg","结果为"+res);
        return "test";
    }
}
