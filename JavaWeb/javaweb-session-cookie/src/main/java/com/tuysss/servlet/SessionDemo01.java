package com.tuysss.servlet;

import com.tuysss.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionDemo01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决乱码问题
        resp.setCharacterEncoding("utf-16");
        req.setCharacterEncoding("utf-16");
        resp.setContentType("text/html;charset=utf-16");

        //得到session
        HttpSession session = req.getSession();

        //向session中存东西
        session.setAttribute("name", new Person("tuysss",1999,38));
        //获取session的id
        String id=session.getId();

        if(session.isNew()){
            resp.getWriter().write("Session创建成功，ID="+id);
        }else{
            resp.getWriter().write("Session已经存在ID="+id);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
