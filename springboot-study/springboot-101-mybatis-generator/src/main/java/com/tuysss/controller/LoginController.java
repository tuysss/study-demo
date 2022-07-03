package com.tuysss.controller;


import com.tuysss.mapper.BlogMapper;
import com.tuysss.mapper.StudentMapper;
import com.tuysss.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.Objects;

@RestController
public class LoginController {
    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("/stu")
    public String showBlogs(){
        return studentMapper.selectByPrimaryKey(1).getName()+studentMapper.selectByPrimaryKey(2).getName();
    }



}
