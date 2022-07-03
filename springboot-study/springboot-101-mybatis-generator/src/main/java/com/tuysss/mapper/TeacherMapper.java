package com.tuysss.mapper;

import com.tuysss.pojo.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Teacher row);

    int insertSelective(Teacher row);

    Teacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Teacher row);

    int updateByPrimaryKey(Teacher row);
}