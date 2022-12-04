package com.tuysss.three.consumer_unfair;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.tuysss.utils.RabbitMQUtils;
import com.tuysss.utils.SleepUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author tianyanning <tianyanning@kuaishou.com>
 * Created on 2022-11-26
 * @Description
 */
public class WorkerSlow {
    public static final String TASK_QUEUE_NAME = "ACK_QUEUE";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMQUtils.getChannel();

        DeliverCallback deliverCallback= (consumerTag, message) -> {
            //沉睡1s，模拟消息处理比较慢
            SleepUtils.sleep(30);
            System.out.println("接收到的消息是："+new String(message.getBody()));

            //信道中 进行手动应答
            /**
             * 1. 消息的标记tag
             * 2. 是否批量应答
             */
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };

        channel.basicQos(1);

        channel.basicConsume(TASK_QUEUE_NAME,false,deliverCallback,(consumerTag)->{
            System.out.println("消费者 取消消费 接口回调逻辑");
        });

    }
}
