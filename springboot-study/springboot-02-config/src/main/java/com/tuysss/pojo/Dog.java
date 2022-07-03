package com.tuysss.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component //将该类添加到Spring的组件中
public class  Dog {
    @Value("旺财")  //通过反射赋值。区别：set注入
    private String name;
    @Value("3")
    private Integer age;
}
