package com.tuysss.eight.dead_letter_queue;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.tuysss.utils.RabbitMQUtils;

import java.nio.charset.StandardCharsets;

/**
 * Created on 2022-12-02
 *
 * @Author tianyanning <tianyanning@kuaishou.com>
 * @Description 死信队列之生产者代码
 */
public class Producer {
    //普通交换机的名称
    public static final String NORMAL_EXCHANGE="normal_exchange";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();

        //死信消息，设置TTL时间  单位是ms  10000ms是10s
        //AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("10000").build();

        for (int i = 0; i < 10; i++) {
            String message="info"+i;
            //channel.basicPublish(NORMAL_EXCHANGE,"zhangsan",properties,message.getBytes(StandardCharsets.UTF_8));
            //验证：因队列达到最大长度而使消息成为死信, 此时发布不携带特性
            channel.basicPublish(NORMAL_EXCHANGE,"zhangsan",null,message.getBytes(StandardCharsets.UTF_8));
        }

    }

}
