package com.tuysss.two.consumer_fair;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.tuysss.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-25
 * @Description 这是一个工作线程
 */
public class Worker01 {
    //队列
    public static final String QUEUE_NAME="hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        //获取信道
        Channel channel = RabbitMQUtils.getChannel();

        // 接受消息参数
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("接受到的消息："+new String(message.getBody()));
        };

        // 取消消费参数
        CancelCallback cancelCallback = consumerTag -> {
            System.out.println(consumerTag+"消费者 取消消费 接口回调逻辑");
        };

        // 消息的接受
        System.out.println("C2等待接收消息......");
        channel.basicConsume(QUEUE_NAME,true,deliverCallback,cancelCallback);

    }

}
