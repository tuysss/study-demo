package com.tuysss.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Date;

//保存用户上一次访问的时间
public class CookieDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //服务器告诉客户端，到达的时间，把这个时间封装成一个信件，下一次来的时候客户端带给服务器.
        req.setCharacterEncoding("utf-16");
        resp.setCharacterEncoding("utf-16");

        //使用writer字符读写，以防编码问题
        PrintWriter out = resp.getWriter();

        //Cookie，服务端从客户端取得
        Cookie[] cookies = req.getCookies();

        //判断cookie是否存在
        if(cookies!=null){
            out.print("您上一次访问的时间是");

            for (Cookie cookie : cookies) {
                if(cookie.getName().equals("lastLoginTime")){
                    //获取cookie中的值
                    String cookieValue=URLDecoder.decode(cookie.getValue(),"utf-8");
                    long lastLoginTime = Long.parseLong(cookieValue);
                    Date date=new Date(lastLoginTime);
                    out.write(date.toLocaleString());
                }

            }
        }else{
            out.print("这是您第一次访问网站");
        }

        //服务器给客户端响应（发送）一个cookie
        Cookie cookie = new Cookie("lastLoginTime", System.currentTimeMillis()+"");
        resp.addCookie(cookie);
        //cookie有效期为一天
        cookie.setMaxAge(24*60*60);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
