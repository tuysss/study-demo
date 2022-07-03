package com.tuysss.service.user;

import com.tuysss.pojo.User;

import java.util.List;

public interface UserService {
    //获取登录用户的用户信息
    public User login(String userCode, String password);
    //修改用户密码
    public boolean updatePassword(int userID, String newPassword);
    //查询记录数
    public int getUserCount(String userName,int userRole);
    //根据条件查询用户列表
    List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize);
}
