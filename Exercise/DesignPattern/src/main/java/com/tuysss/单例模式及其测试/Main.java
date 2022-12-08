package com.tuysss.单例模式及其测试;

import org.junit.Test;

/**
 * @author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-22
 */

public class Main{
    @Test
    public void test(){
        Singleton s1=Singleton.getInstance();
        System.out.println("创建s1： "+s1.toString());
        Singleton s2=Singleton.getInstance();
        System.out.println("创建s1： "+s2.toString());
    }
}

/**
 * 懒加载，不安全的
 */
class Singleton {
    private static Singleton instance;

    private Singleton(){}

    public static Singleton getInstance() {
        if(instance==null){
            instance=new Singleton();
        }
        return instance;
    }

    //method
}


/**
 * 双重锁校验 安全的
 * 问题 1.为什么两次判断null 2.为什么必须用volatile？具体是防止哪一段代码重排序？
 * https://blog.csdn.net/May_3/article/details/82180961
 */
class SingletonDoubleLocking{
    private static volatile SingletonDoubleLocking instance;

    private SingletonDoubleLocking(){}

    public static SingletonDoubleLocking getInstance(){
        if(instance==null){
            synchronized (SingletonDoubleLocking.class){
                if(instance==null){
                    instance=new SingletonDoubleLocking();
                }
            }
        }
        return instance;
    }

}




