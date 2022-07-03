package com.tuysss.dao;

import com.tuysss.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    //根据ID查询用户
    User getUserByID(int id);
    //模糊查询
    User getUserLike(String nameValue);

    //插入一个用户
    int addUser(User user);

    //万能的map，替代User实体类（必须new一个对象，new出所有的属性），map可以只调需要的属性
    int addUser2(Map<String,Object> map);

    //修改用户
    int updateUser(User user);

}
