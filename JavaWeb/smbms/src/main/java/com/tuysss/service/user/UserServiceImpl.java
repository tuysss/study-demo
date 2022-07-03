package com.tuysss.service.user;

import com.tuysss.dao.BaseDao;
import com.tuysss.dao.user.UserDao;
import com.tuysss.dao.user.UserDaoImpl;
import com.tuysss.pojo.User;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public UserServiceImpl(){
        userDao=new UserDaoImpl();  //获取底层dao实例
    }


    @Override
    public User login(String userCode, String password) {
        Connection connection=null;
        User user=null;

        try {
            connection=BaseDao.getConnection();
            user=userDao.getLoginUser(connection,userCode);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }

        if(null!=password){
            if(!password.equals(user.getUserPassword())){
                user=null;
            }
        }
        return user;
    }

    @Override
    public boolean updatePassword(int userID, String newPassword) {
        Connection connection=null;
        boolean flag=false;
        try {
            connection=BaseDao.getConnection();
            if(userDao.updatePassword(connection,userID,newPassword)>0){//==1
                flag=true;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return flag;
    }

    @Override
    public int getUserCount(String userName, int userRole) {
        Connection connection=null;
        int userCount=0;
        try {
            connection = BaseDao.getConnection();
            userCount = userDao.getUserCount(connection, userName, userRole);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return userCount;
    }

    @Override
    public List<User> getUserList(String userName, int userRole, int currentPageNo, int pageSize) {
        Connection connection=null;
        List<User> userList=null;
        try {
            connection=BaseDao.getConnection();
            userList=userDao.getUserList(connection,userName,userRole,currentPageNo,pageSize);
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            BaseDao.closeResource(connection,null,null);
        }
        return userList;
    }

    @Test
    public void testGetUserList(){
        UserServiceImpl userService = new UserServiceImpl();
        List<User> userList=userService.getUserList("",0,1,5);
        for (User user : userList) {
            System.out.println(user.getUserName());
        }
    }


    @Test
    public void testLogin(){
        UserServiceImpl userService = new UserServiceImpl();
        int userCount=userService.getUserCount(null,3);
        System.out.println(userCount);
    }







}
