package com.tuysss.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-25
 * 连接工厂、创建信道的工具类
 */

public class RabbitMQUtils {
    public static Channel getChannel() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("118.195.147.113");
        //connectionFactory.setPort(5672);
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123");
        Connection connection=connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        return channel;
    }
}
