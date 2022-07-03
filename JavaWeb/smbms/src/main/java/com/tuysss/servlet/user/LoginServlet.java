package com.tuysss.servlet.user;

import com.sun.org.apache.bcel.internal.classfile.Constant;
import com.tuysss.pojo.User;
import com.tuysss.service.user.UserService;
import com.tuysss.service.user.UserServiceImpl;
import com.tuysss.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    //servlet:控制层，调用业务层
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("LoginAervlet---start...");
        //获取用户名和密码
        String userCode = req.getParameter("userCode");
        String userPassword = req.getParameter("userPassword");

        //和数据库中的密码对比,调用业务层
        UserService userService = new UserServiceImpl();
        User user= userService.login(userCode, userPassword);

        if(null!=user){//登录成功
            //将用户信息放到session中,这样只要用户没有注销，全部的用户信息都可以随时查询
            req.getSession().setAttribute(Constants.USER_SESSION,user);
            //跳转到内部主页
            resp.sendRedirect("jsp/frame.jsp");
        }else{
            req.setAttribute("error","用户名或密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
