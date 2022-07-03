package com.tuysss.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

public class test11 {
     public static void test01(){
         User user=new User();
         long startTime=System.currentTimeMillis();

        for (int i = 0; i < 100000000; i++) {
            user.getAge();
        }

         long endTime=System.currentTimeMillis();
        System.out.println("普通方法："+(endTime-startTime)+"ms");
    }


    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user=new User();
        Class c1=user.getClass();
        Method getAge=c1.getDeclaredMethod("getAge",null);

        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            getAge.invoke(user,null);
        }
        long endTime=System.currentTimeMillis();

        System.out.println("反射方法："+(endTime-startTime)+"ms");
    }

    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User user=new User();
        Class c1=user.getClass();
        Method getAge=c1.getDeclaredMethod("getAge",null);
        getAge.setAccessible(true);

        long startTime=System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            getAge.invoke(user,null);
        }
        long endTime=System.currentTimeMillis();

        System.out.println("反射关闭检测方法："+(endTime-startTime)+"ms");
    }

    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        test01();
        test02();
        test03();
    }


    HashSet<String> set=new HashSet<>();








}
