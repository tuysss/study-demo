package com.tuysss.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//Component组件：等价于在beans.xml文件中注册了：<bean id="user" class="com.tuysss.pojo.User"/>
//getBean时，用首字母小写的类名user
@Component
public class User {
    public String name;

    //相当于bean中的property
    @Value("Lilys")
    public void setName(String name) {
        this.name = name;
    }
}
