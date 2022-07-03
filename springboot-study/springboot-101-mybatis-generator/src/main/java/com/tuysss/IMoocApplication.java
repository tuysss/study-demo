package com.tuysss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com/tuysss/mapper")
public class IMoocApplication {

    public static void main(String[] args) {
        SpringApplication.run(IMoocApplication.class, args);
    }

}
