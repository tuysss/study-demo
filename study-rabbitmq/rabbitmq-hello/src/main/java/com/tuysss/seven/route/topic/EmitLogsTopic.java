package com.tuysss.seven.route.topic;

import com.rabbitmq.client.Channel;
import com.tuysss.utils.RabbitMQUtils;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-28
 * @Description
 */
public class EmitLogsTopic {
    public static final String EXCHANGE_NAME="topic_logs";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();

        Map<String,String> map=new HashMap<>(8);
        map.put("quick.orange.rabbit","被队列Q1Q2接收到");
        map.put("quick.orange.fox","被队列Q1接收到");
        map.put("lazy.brown.fox","被队列Q2接收到 ");
        map.put("lazy.pink.rabbit","虽然满足队列Q2的两个绑定但是只会被接收一次");
        map.put("quick.orange.male.rabbit","四个单词不匹配任何绑定会被丢弃");

        for (Map.Entry<String, String> bindingKeyEntry : map.entrySet()) {
            String routingKey=bindingKeyEntry.getKey();
            String expectedResult=bindingKeyEntry.getValue();

            channel.basicPublish(EXCHANGE_NAME,routingKey,null,expectedResult.getBytes(StandardCharsets.UTF_8));
            System.out.println("生产者发送消息："+expectedResult);
        }
        //channel.close();
    }

}
