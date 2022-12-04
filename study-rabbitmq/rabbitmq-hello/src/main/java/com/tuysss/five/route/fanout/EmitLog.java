package com.tuysss.five.route.fanout;

import com.rabbitmq.client.Channel;
import com.tuysss.utils.RabbitMQUtils;

import java.util.Scanner;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-27
 * @Description 发消息给交换机
 * ps. 三个地方都声明channel是为了线程启动的顺序可以随意
 */
public class EmitLog {
    public static final String EXCHANGE_NAME="logs";

    public static void main(String[] args) throws Exception{
        Channel channel = RabbitMQUtils.getChannel();
        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String msg = in.next();
            channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes("utf-8"));
            System.out.println("生产者发出消息："+msg);
        }
    }
}
