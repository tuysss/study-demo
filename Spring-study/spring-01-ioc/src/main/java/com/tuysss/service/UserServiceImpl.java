package com.tuysss.service;

import com.tuysss.dao.*;

public class UserServiceImpl implements UserService{
    //private UserDao userDao=new UserDaoOracleImpl();
    private UserDao userDao;

    @Override
    public void getUser() {
        userDao.getUser();
    }

    //动态注入
    public void setUser(UserDao userDao){
        this.userDao=userDao;
    }
}
