package com.tuysss.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private Teacher teacher;  //学生需要关联一个老师
}