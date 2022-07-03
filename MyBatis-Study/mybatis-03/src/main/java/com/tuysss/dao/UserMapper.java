package com.tuysss.dao;

import com.tuysss.pojo.User;

import java.util.List;

public interface UserMapper {
    //根据ID查询用户
    User getUserByID(int id);

}
