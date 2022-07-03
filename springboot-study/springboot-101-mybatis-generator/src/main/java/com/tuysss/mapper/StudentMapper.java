package com.tuysss.mapper;

import com.tuysss.pojo.Student;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Student row);

    int insertSelective(Student row);

    Student selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Student row);

    int updateByPrimaryKey(Student row);
}
