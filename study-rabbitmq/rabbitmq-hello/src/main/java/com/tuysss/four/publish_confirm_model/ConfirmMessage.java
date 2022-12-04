package com.tuysss.four.publish_confirm_model;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.tuysss.utils.RabbitMQUtils;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-27
 * @Description 发布确认模式--通过时间 比较哪种确认方式最优
*           1. 单个确认
 *          2. 批量确认
 *          3. 异步批量确认
 */
public class ConfirmMessage {
    public static final int MESSAGE_COUNT=1000;

    public static void main(String[] args) throws IOException, InterruptedException, TimeoutException {
        // 1. 单个确认 ：102352ms
        //publishMessageIndividually();
        // 2. 批量确认 : 1961ms
        //publishMessageBatch();
        // 3. 异步批量确认 : 68ms   ？但是只是消息接收完成的时间，而非完成确认的时间
        publishMessageAsynchronized();

    }
    // 1. 单个确认
    public  static void publishMessageIndividually() throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitMQUtils.getChannel();

        String queueName= UUID.randomUUID().toString();
        channel.queueDeclare(queueName,false,false,false,null);

        channel.confirmSelect();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            channel.basicPublish("",queueName,null, (i + " ").getBytes());
            boolean flag = channel.waitForConfirms();
            if(flag){
                System.out.println("消息发送成功");
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("发送"+MESSAGE_COUNT+"条消息，单个确认发布用时："+ (end-begin)+"ms");
    }

    // 2. 批量确认
    public static void publishMessageBatch() throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitMQUtils.getChannel();

        String queueName= UUID.randomUUID().toString();
        channel.queueDeclare(queueName,false,false,false,null);

        channel.confirmSelect();
        int batchSize=100;

        long begin = System.currentTimeMillis();

        for (int i = 0; i < MESSAGE_COUNT; i++) {
            channel.basicPublish("",queueName,null, (i + " ").getBytes());
            if((i+1)%batchSize==0){
                channel.waitForConfirms();
                System.out.println("消息发送成功");
            }
        }
        long end = System.currentTimeMillis();

        System.out.println("发送"+MESSAGE_COUNT+"条消息，批量确认发布用时："+ (end-begin)+"ms");
    }


    // 3. 异步批量确认
    public static void publishMessageAsynchronized() throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitMQUtils.getChannel();
        String queueName= UUID.randomUUID().toString();
        channel.queueDeclare(queueName,false,false,false,null);
        //开启确认发布
        channel.confirmSelect();

        //消息确认成功 回调函数
        ConfirmCallback ackConformCallBack=(deliveryTag, multiple)->{
            System.out.println("确认消息为："+deliveryTag);
        };
        //消息确认失败 回调函数
        ConfirmCallback nAckConformCallBack=(deliveryTag, multiple)->{
            System.out.println("未确认消息为："+deliveryTag);
        };

        // 准备消息的监听器，监听哪些消息成功，哪些消息失败
        channel.addConfirmListener(ackConformCallBack,nAckConformCallBack);


        long begin = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            channel.basicPublish("",queueName,null, (i + " ").getBytes());

        }
        long end = System.currentTimeMillis();

        System.out.println("发送"+MESSAGE_COUNT+"条消息，异步确认发布用时："+ (end-begin)+"ms");
    }

}
