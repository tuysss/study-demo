package com.tuysss.mapper;

import com.tuysss.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  //这个注解表示一个mybatis的mapper类
@Repository
public interface UserMapper {

    List<User> queryUserList();

    User queryuserById();

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
