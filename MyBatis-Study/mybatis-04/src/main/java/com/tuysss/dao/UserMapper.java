package com.tuysss.dao;

import com.tuysss.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //根据ID查询用户
    User getUserByID(int id);

    List<User> getUserByLimit(Map<String,Object> map);
}
