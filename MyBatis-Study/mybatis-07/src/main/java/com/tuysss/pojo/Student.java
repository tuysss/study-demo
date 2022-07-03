package com.tuysss.pojo;

import lombok.Data;

@Data
public class Student {
    private int id;
    private String name;
    private int tid; //重构：学生和老师一对一
}