package com.tuysss.eight.dead_letter_queue;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.tuysss.utils.RabbitMQUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2022-11-29
 *
 * @Author tianyanning <tianyanning@kuaishou.com>
 * @Description 死信队列 能够正常接收消息的consumer01
 */
public class Consumer01 {
    //普通队列对应交换机
    public static final String NORMAL_EXCHANGE="normal_exchange";
    //死信队列对应交换机
    public static final String DEAD_EXCHANGE="dead_exchange";
    //普通队列
    public static final String NORMAL_QUEUE="normal_queue";
    //死信队列
    public static final String DEAD_QUEUE="dead_queue";

    public static void main(String[] args) throws Exception {
        Channel channel = RabbitMQUtils.getChannel();
        //声明死信和普通交换机，类型为direct
        channel.exchangeDeclare(NORMAL_EXCHANGE, BuiltinExchangeType.DIRECT);
        channel.exchangeDeclare(DEAD_EXCHANGE,BuiltinExchangeType.DIRECT);

        //声明普通队列 ：终于最后一个参数不是null了
        //channel.queueDeclare(NORMAL_QUEUE,false,false,false,null);

        Map<String, Object> arguments=new HashMap<>();

        //过期时间 -> 尽量不在接收队列处设置过期时间，而是在生产方发送消息时设置
        //arguments.put("x-message-ttl",10000);

        //正常队列需要设置过期之后，转发给的交换机是谁
        arguments.put("x-dead-letter-exchange",DEAD_EXCHANGE);

        //设置死信routingKey
        arguments.put("x-dead-letter-routing-key","lisi");

        //设置正常队列的长度的限制:->验证：超出队列长度之后被转发至死信队列
        // 注意⚠️：这里普通队列的声明参数被修改，运行将会报错，需要到服务器端删除normal——queue队列，再次运行，重新创建这个队列
        //arguments.put("x-max-length",6);



        channel.queueDeclare(NORMAL_QUEUE,false,false,false,arguments);

        ////////////////////////////////////////////////////////////////////////
        //声明死信队列
        channel.queueDeclare(DEAD_QUEUE,false,false,false,null);

        //绑定普通队列与普通交换机 （by路由
        channel.queueBind(NORMAL_QUEUE,NORMAL_EXCHANGE,"zhangsan");
        //绑定死信队列与死信交换机 （by路由
        channel.queueBind(DEAD_QUEUE,DEAD_EXCHANGE,"lisi");

        System.out.println("等待接收消息。。。。。");

        //验证：消息成为死信的第三种情况：消息被拒绝
        DeliverCallback deliverCallback = (consumerTag, message) -> {
            String msg = new String(message.getBody());
            if("info5".equals(msg)){
                System.out.println("消息：" + msg+"被Consumer01拒绝接收");
                channel.basicReject(message.getEnvelope().getDeliveryTag(),false);
            }else{
                System.out.println("Consumer01接收的消息是：" + msg);
                channel.basicAck(message.getEnvelope().getDeliveryTag(),false);
            }

        };


        //channel.basicConsume(NORMAL_QUEUE,true,deliverCallback,consumerTag->{});
        //开启手动应答 (自动应答不存在拒绝问题
        channel.basicConsume(NORMAL_QUEUE,false,deliverCallback,consumerTag -> {});



    }


}
