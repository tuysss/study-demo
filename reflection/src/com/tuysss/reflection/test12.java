package com.tuysss.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

//练习反射操作注解
public class test12 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1=Class.forName("com.tuysss.reflection.Student");

        //通过反射获取注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
        //获取注解的value的值
        Tabletuy tabletuy = (Tabletuy)c1.getAnnotation(Tabletuy.class);
        String value = tabletuy.value();
        System.out.println(value);

        //获得类指定的注解
        Field f = c1.getDeclaredField("name");
        Fieldtuy annotation = f.getAnnotation(Fieldtuy.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());


    }

}

@Tabletuy("db_student")
class Student{
    @Fieldtuy(columnName="db_id",type="int",length=10)
    private int id;
    @Fieldtuy(columnName="db_age",type="int",length=10)
    private int age;
    @Fieldtuy(columnName="db_name",type="varchar",length=10)
    private String name;

    public Student() {
    }
    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tabletuy{
    String value();
}
//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldtuy{
    String columnName();
    String type();
    int length();
}


