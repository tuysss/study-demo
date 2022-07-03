package com.tuysss.controller;
/*
本类中的内容：接收数据
一，处理提交数据
1.1 提交的域名（url中？后参数）和处理方法的参数名一致，见test1
1.2 不一致，增加@RequestParam("username")注解，“username”是前端/url中的名
    @RequestParam注解优点：可以表明该参数是从前端接收来的
1.3 从前端接收的是一个对象，见test2
    假设传递的是一个对象User：提交的表单域和User对象中的字段名进行匹配。如果名字一样则ok，否则匹配不到
二，数据显示到前端
2.1 ModelAndView(略)
2.2 ModelMap: 继承了LinkedHashMap
2.3 Model(略)：精简版，一般够用
 */

import com.sun.org.glassfish.gmbal.ParameterNames;
import com.tuysss.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1") //httpservlet的get请求
    public String test1(@RequestParam("username")String name, Model model){
        //1. 接收前端参数(本操作已自动完成)
        System.out.println("接收到前端的参数为："+name);
        //2. 将返回的结果返回给前端——使用Model实体
        model.addAttribute("msg",name);
        //3. 跳转视图
        return "test";
    }

    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }

    @GetMapping("/t3")
    public String test3(ModelMap map){

        return "test";
    }



}
