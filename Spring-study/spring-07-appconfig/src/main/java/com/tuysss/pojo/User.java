package com.tuysss.pojo;

import org.springframework.beans.factory.annotation.Value;


public class User {
    private String name;

    public String getName() {
        return name;
    }

    @Value("忘克莱尔")
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
