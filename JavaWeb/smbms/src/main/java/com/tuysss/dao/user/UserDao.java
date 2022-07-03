package com.tuysss.dao.user;

import com.tuysss.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    //得到登录用户的全部用户信息
    public User getLoginUser(Connection connection,String userCode) throws SQLException;

    //根据用户id修改密码
    public int updatePassword(Connection connection,int id,String newPassword) throws SQLException;

    //根据用户名或者用户角色查询用户总数
    public int getUserCount(Connection connection,String userName,int userRole) throws SQLException;

    //根据条件获取用户列表
    public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws SQLException;

}

