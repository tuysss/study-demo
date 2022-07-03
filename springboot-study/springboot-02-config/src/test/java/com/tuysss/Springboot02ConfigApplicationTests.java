package com.tuysss;

import com.tuysss.pojo.Dog;
import com.tuysss.pojo.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot02ConfigApplicationTests {

    @Autowired  //寻找容器的组件Component，自动装配
    //@Qualifier() //指定具体的一条狗
    private Person person;

    @Test
    void contextLoads() {
        System.out.println(person);
    }

}
