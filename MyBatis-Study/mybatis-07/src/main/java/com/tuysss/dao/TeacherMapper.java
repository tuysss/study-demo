package com.tuysss.dao;

import com.tuysss.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    //获取老师
    List<Teacher> getTeacherList();

    //获取指定老师，及其学生的完整信息
    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher2(@Param("tid") int id);



}
