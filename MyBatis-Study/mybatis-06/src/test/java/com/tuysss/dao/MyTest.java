package com.tuysss.dao;

import com.tuysss.pojo.Student;
import com.tuysss.pojo.Teacher;
import com.tuysss.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.rules.TestRule;

import java.util.List;

public class MyTest {
    @Test
    public void TestInit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);
        sqlSession.close();
    }

    @Test
    public void TestGetStudent(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent();
        for (Student student: studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

    @Test
    public void TestGetStudent2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> studentList = mapper.getStudent2();
        for (Student student: studentList) {
            System.out.println(student);
        }
        sqlSession.close();
    }

}
