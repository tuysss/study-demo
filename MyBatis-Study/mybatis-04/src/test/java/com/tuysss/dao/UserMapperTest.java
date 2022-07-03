package com.tuysss.dao;

import com.tuysss.pojo.User;
import com.tuysss.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;


public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void TestGetUserByLimit(){
        //sqlSession:连接到连接池的一个实例
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("startIndex",1);
        map.put("pageSize",2);
        List<User> userList = mapper.getUserByLimit(map);
        for (User user : userList) {
            logger.info(user);
        }


    }

    @Test
    public void getUserListTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserByID(2);
        System.out.println(user);
    }

    @Test
    public void TestLog4j(){
        logger.info("info:进入了Log4j");
        logger.debug("debug:进入了Log4j");
        logger.error("error:进入了Log4j");
    }
}
