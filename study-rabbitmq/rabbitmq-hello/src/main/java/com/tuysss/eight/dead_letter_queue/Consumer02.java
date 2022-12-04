package com.tuysss.eight.dead_letter_queue;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.tuysss.utils.RabbitMQUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2022-12-02
 *
 * @Author tianyanning <tianyanning@kuaishou.com>
 * @Description 消费者，消费死信队列里的消息
 */
public class Consumer02 {
    //死信队列
    public static final String DEAD_QUEUE="dead_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();


        System.out.println("等待接收消息。。。。。");

        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("Consumer02接收的消息是：" + new String(message.getBody()));
        };

        channel.basicConsume(DEAD_QUEUE,true,deliverCallback,consumerTag->{});


    }
}
