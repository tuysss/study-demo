package com.tuysss.dao;

import com.tuysss.pojo.Student;
import com.tuysss.pojo.Teacher;

import java.util.*;

public interface StudentMapper {
    //查询所有的学生信息，以及对应的老师信息
    List<Student> getStudent();
    //Teacher getTeacher(int id);

    List<Student> getStudent2();
}
