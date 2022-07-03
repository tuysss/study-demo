package com.tuysss.pojo;

public class User {
    private String name;

    /*  有参构造出现，无参构造消失
        无参构造在getbean之前被实例化，所有在bean中注册过的类统统被实例化！内存中只有一份实例（默认是单例）
        有参构造在bean中的实现，官方文档提供了三种配置方式
     */
    public User(String name){
        System.out.println("User的有参构造！");
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show(){
        System.out.println("name="+this.name);
    }
}
