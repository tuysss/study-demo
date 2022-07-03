package com.tuysss.demo01;

public class Proxy implements rent{
    private Host host;

    public Proxy(){

    }
    public Proxy(Host host){
        this.host=host;
    }


    @Override
    public void rent() {
        seeHouse();
        host.rent();
        sell();
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    public void sell(){
        System.out.println("房屋交易");
    }
}
