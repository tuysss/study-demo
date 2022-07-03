package com.tuysss.filter;

import com.tuysss.pojo.User;
import com.tuysss.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SysFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //过滤器默认过滤请求、重定向。（不包含转发）
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) servletRequest;
        HttpServletResponse resp=(HttpServletResponse) servletResponse;
        //过滤器，从session中获取对象
        User user =(User) req.getSession().getAttribute(Constants.USER_SESSION);

        if(user==null){ //session已经被移除或者注销，或者尚未登录
            //此webapp的命名是smbms，即tomcat部署时的命名
            resp.sendRedirect("/smbms/error.jsp");
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
