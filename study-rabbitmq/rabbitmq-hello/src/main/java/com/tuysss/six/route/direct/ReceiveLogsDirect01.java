package com.tuysss.six.route.direct;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.tuysss.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-27
 * @Description
 */
public class ReceiveLogsDirect01 {
    public static final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        //创建信道
        Channel channel = RabbitMQUtils.getChannel();
        //声明一个队列
        channel.queueDeclare("disk",false,false,false,null);
        //绑定交换机与队列
        channel.queueBind("disk",EXCHANGE_NAME,"error");

        DeliverCallback deliverCallback = (consumerTag, message) -> {
            System.out.println("ReceiveLogsDirect01控制台打印接受到的消息：" + new String(message.getBody()));
        };

        channel.basicConsume("console",true,deliverCallback,consumerTag -> {});

    }
}
