package com.tuysss.seven.route.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.tuysss.utils.RabbitMQUtils;

import javax.print.DocFlavor;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-28
 * @Description 声明主题交换机及其相关队列 消费者C2
 * ps.一个消费者从一个队列中取消息，一个队列绑定一个交换机，一个交换机可以有多个路由规则
 */
public class ReceiverLogsTopic02 {
    public static final String EXCHANGE_NAME= "topic_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        //声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME,"topic",false,false,null);
        //声明队列
        String queueName= "Q2";
        channel.queueDeclare(queueName,false,false,false,null);
        //队列捆绑
        channel.queueBind(queueName,EXCHANGE_NAME,"*.*.rabbit");
        channel.queueBind(queueName,EXCHANGE_NAME,"*lazy.#");
        System.out.println("等待接收消息");
        System.out.println("消费者C2 对应队列Q2, Q2路由key为："+"*.*.rabbit"+"和"+"*lazy.#"+"\n");

        DeliverCallback deliverCallback = (consumerTag, message) -> {
            //basicPublish时发送的messagebody
            System.out.println(new String(message.getBody()));
            //每次consumer接收，回调给publisher的消息
            System.out.println("接收的消息来自队列："+queueName+"队列的routingKey为："+message.getEnvelope().getRoutingKey());
        };

        channel.basicConsume(queueName,true,deliverCallback,(consumerTag)->{});
    }
}
