package com.tuysss.dao;

import com.tuysss.pojo.User;
import com.tuysss.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {
    @Test
    public void getUserListTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        for (User user : mapper.getUserList()) {
            System.out.println(user);
        }
    }
}
