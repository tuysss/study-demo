package com.tuysss.five.route.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.tuysss.utils.RabbitMQUtils;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-27
 * @Description
 */
public class ReceiverLogs2 {
    //交换机名称
    public static final String EXCHANGE_NAME="logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        //声明一个交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
        //声明一个临时队列
        String queueName = channel.queueDeclare().getQueue();
        //绑定交换机与队列
        channel.queueBind(queueName,EXCHANGE_NAME,"");
        System.out.println("ReceiverLogs2等待接收消息，把接收到的消息打印在屏幕上");

        //接收消息后，消费者端回调
        DeliverCallback deliverCallback= (consumerTag, message) -> {
            System.out.println("消费者接收到的消息："+ new String(message.getBody(),"utf-8"));
        };

        channel.basicConsume(queueName,deliverCallback,consumerTag ->{} );

    }
}
