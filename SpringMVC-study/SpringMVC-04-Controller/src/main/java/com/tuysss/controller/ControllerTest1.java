package com.tuysss.controller;
/*
方法一：实现Controller接口的方法
总结：几乎不使用该方法。因为1.需要注册bean 2.一个控制器中只有一个方法
 */
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//只要实现了Controller接口的类，说明这就是一个控制器了
public class ControllerTest1 implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv=new ModelAndView();

        mv.addObject("msg","ControllerTest1");
        mv.setViewName("test"); //跳转到页面

        return mv;
    }
}
