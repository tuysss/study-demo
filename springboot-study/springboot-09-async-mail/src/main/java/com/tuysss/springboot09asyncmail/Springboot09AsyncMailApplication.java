package com.tuysss.springboot09asyncmail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync  //开启异步注解功能
@EnableScheduling  //开启定时功能
public class Springboot09AsyncMailApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09AsyncMailApplication.class, args);
    }

}
