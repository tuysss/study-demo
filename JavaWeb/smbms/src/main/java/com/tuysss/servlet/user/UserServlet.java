package com.tuysss.servlet.user;

import com.alibaba.fastjson.JSONArray;

import com.mysql.jdbc.StringUtils;
import com.tuysss.pojo.Role;
import com.tuysss.pojo.User;
import com.tuysss.service.role.RoleService;
import com.tuysss.service.role.RoleServiceImpl;
import com.tuysss.service.user.UserService;
import com.tuysss.service.user.UserServiceImpl;
import com.tuysss.util.Constants;
import com.tuysss.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

//实现servlet复用
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method=req.getParameter("method");
        if(method!=null&&method.equals("savepwd")){
            this.updatePwd(req,resp);
        }else if(method!=null&&method.equals("pwdmodify")){
            this.pwdModify(req,resp);
        }else if(method!=null&&method.equals("query")){
            this.query(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

    //用户管理
    private void query(HttpServletRequest req, HttpServletResponse resp){
        //从前端获取默认数据
        String queryUserName=req.getParameter("queryname");
        String defalutRole=req.getParameter("queryUserRole");
        String pageIndex = req.getParameter("pageIndex");
        int queryUserRole=0;

        //获取用户列表
        UserService userService=new UserServiceImpl();
        //获取角色列表
        RoleService roleService=new RoleServiceImpl();

        //第一次走这个页面，一定是第一页，页面大小固定的
        int pageSize=5;   //一般地，应该放在配置文件中，方便修改
        int currentPageNo=1;

        if(queryUserName==null){
            queryUserName="";
        }
        if(defalutRole!=null && !defalutRole.equals("")){
            queryUserRole=Integer.parseInt(defalutRole);
        }
        if(pageIndex!=null){
            currentPageNo = Integer.parseInt(pageIndex);
        }
        //获取用户的总数
        int totalCount = userService.getUserCount(queryUserName, queryUserRole);

        PageSupport pageSupport=new PageSupport();
        pageSupport.setPageSize(pageSize);
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setTotalCount(totalCount);

        int totalPageCount=pageSupport.getTotalPageCount();

        //控制首页和尾页
        if(currentPageNo<1){
            currentPageNo=1;
        }else if(currentPageNo>totalPageCount){
            currentPageNo=totalPageCount;
        }

        //获取用户列表展示
        List<User> userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
        //
        req.setAttribute("userList",userList);//req.getSession().setAttribute("userList",userList);

        //获取角色列表展示
        List<Role> roleList = roleService.getRoleList();
        req.setAttribute("roleList",roleList);
        req.setAttribute("totalCount",totalCount);
        req.setAttribute("currentPageNo",currentPageNo);
        req.setAttribute("totalPageCount",totalPageCount);
        req.setAttribute("queryUserName",queryUserName);
        req.setAttribute("queryUserRole",queryUserRole);

        //返回前端
        try {
            req.getRequestDispatcher("userlist.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //修改密码
    private void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        //从session中获取用户id    ->缓存服务器
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String newpassword = req.getParameter("newpassword");
        boolean flag=false;
        if(null!=o&& !StringUtils.isNullOrEmpty(newpassword)){
            int id=((User)o).getId();
            flag = userService.updatePassword(id, newpassword);
            if(flag){
                //req.setAttribute(Constants.USER_SESSION,user);
                req.setAttribute("message","修改密码成功，请退出并重新登录。");
                //密码修改成功，移除当前session. ps.下次登录时会在session中添加attribute
                req.getSession().removeAttribute(Constants.USER_SESSION);
                //resp.sendRedirect("login.jsp");  filter做
            }else{
                req.getSession().setAttribute("message","密码修改失败。");
            }
        }else{
            req.getSession().setAttribute("message","新密码输入错误。");
        }
        req.getRequestDispatcher("pwdmodify.jsp").forward(req,resp);
    }

    //验证旧密码,session中有用户的密码
    private void pwdModify(HttpServletRequest req, HttpServletResponse resp){
        Object o = req.getSession().getAttribute(Constants.USER_SESSION);
        String oldpassword = req.getParameter("oldpassword");

        //map结果集，不然：只改表中的一项就需要new一个对象，浪费
        HashMap<String, String> resultMap=new HashMap<>();

        if(o==null){//session失效或过期
            resultMap.put("result","sessionerror");
        }else if(StringUtils.isNullOrEmpty(oldpassword)){//输入的密码为空
            resultMap.put("result","error");
        }else{
            String userPassword = ((User) o).getUserPassword();//Session中用户更改前的密码
            if(oldpassword.equals(userPassword)){
                resultMap.put("result","true");
            }else{
                resultMap.put("result","false");
            }
        }

        try {
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            //TODO:JSON
            writer.write(JSONArray.toJSONString(resultMap));
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
