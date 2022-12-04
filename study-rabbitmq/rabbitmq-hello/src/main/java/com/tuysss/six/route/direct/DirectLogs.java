package com.tuysss.six.route.direct;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.tuysss.utils.RabbitMQUtils;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-27
 * @Description
 */
public class DirectLogs {
    // 交换机的名称
    public  static  final String EXCHANGE_NAME = "direct_logs";

    public static void main(String[] args) throws  Exception{
        Channel channel = RabbitMQUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT);

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String message = scanner.next();
            channel.basicPublish(EXCHANGE_NAME,"info",null,message.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发出的消息："+ message);
        }
    }
}

