package com.tuysss.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//扩展springmvc,官方的建议
@Configuration
@EnableWebMvc  //会将所有mvc配置全部失效，失去springboot的接管（不要用）
public class MyMvcConfig implements WebMvcConfigurer {

    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/tuysss").setViewName("test");
    }

    /**   另一种方法：（官方不建议）
     *     //ViewResolver 实现了视图解析器接口的类，我们就可以把它看做视图解析器
     *     //@bean注入，交给springboot
     */
}
