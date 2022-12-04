package com.tuysss.one;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-23
 */
public class Consumer {
    public static final String QUEUE_NAME="hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("118.195.147.113");
        //connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123");

        Connection connection=connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        System.out.println("等待接收消息。。。");


        DeliverCallback deliverCallback=(consumerTag, message)->{
            String s=new String(message.getBody());
            System.out.println(s);
        };


        CancelCallback cancelCallback=(consumerTag)->{
            System.out.println("消息消费被中断");
        };


        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);
    }

}
