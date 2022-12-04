package com.tuysss.two.consumer_fair;

import com.rabbitmq.client.Channel;
import com.tuysss.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-26
 * @Description 生产者 发送大量消息
 */
public class Task01 {
    //队列名称
    public  static final String QUEUE_NAME="hello";

    //发送大量消息
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getChannel();
        //队列的声明
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String msg=in.next();
            //发送消息
            channel.basicPublish("", QUEUE_NAME, null, msg.getBytes());
            System.out.println("消息发送："+msg+" 完成");
        }



    }
}
