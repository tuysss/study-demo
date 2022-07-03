package com.tuysss.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharacterEncodingFilter implements Filter {

    //Web服务器启动，立即初始化，以便随时等候监听
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CharacterEncodingFilter初始化");
    }
    /*
    1. 过滤中的所有底阿妈，在过滤特定请求的时候都会执行
    2. 必须要让过滤器继续同行
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html; charset=UTF-8");
        System.out.println("CharacterEncodingFilter执行前。。。");
        //让程序继续走下去。不写的话程序会被拦截停止。
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("CharacterEncodingFilter执行后。。。");
    }

    //销毁
    @Override
    public void destroy() {
        System.out.println("CharacterEncodingFilter销毁");
    }
}
