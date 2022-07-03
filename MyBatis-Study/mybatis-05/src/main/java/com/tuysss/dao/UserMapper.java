package com.tuysss.dao;

import com.tuysss.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from mybatis.user")
    List<User> getUserList();

    //@Param注解：用于基本类型和String类型，引用类型不需要，仅一个参数不需要（也可以要）
    @Select("select *from mybatis.user where id=#{uid}")
    User getUserById(@Param("uid") int id);

    @Insert("insert into mybatis.user(id,name,pwd) values(#{id},#{name},#{password})")
    int addUser(User user);
}
