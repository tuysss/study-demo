package com.tuysss.three.consumer_unfair;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.tuysss.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-26
 * @Description 验证：消息在手动应答时是不丢失的，放回队列重新消费
 */
public class Task02 {
    public static final String TASK_QUEUE_NAME = "ACK_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getChannel();
        //开启发布确认模式
        channel.confirmSelect();

        //声明信道，基本配置
        //队列实现持久化
        channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);

        Scanner in=new Scanner(System.in);
        while(in.hasNext()){
            String message=in.next();
            //消息实现持久化——保存在磁盘中，otherwise，内存
            channel.basicPublish("",TASK_QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes("utf-8"));
            System.out.println("生产者发送消息："+message);
        }


    }
}
