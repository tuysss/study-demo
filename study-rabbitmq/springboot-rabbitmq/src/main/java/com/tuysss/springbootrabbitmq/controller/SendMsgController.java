package com.tuysss.springbootrabbitmq.controller;

import com.tuysss.springbootrabbitmq.config.DelayedQueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created on 2022-12-05
 *
 * @Author tianyanning <tianyanning@kuaishou.com>
 * @Description 生产者代码 发送延迟消息
 */
@Slf4j
@RestController
@RequestMapping("/ttl")
//
public class SendMsgController {

    @Autowired
    private RabbitTemplate rabbitTemplate;  //Spring提供的

    //开始发消息
    @GetMapping("/sendMsg/{message}")
    public void sendMsg(@PathVariable String message){

        rabbitTemplate.convertAndSend("X","XA","消息来自TTL为10s的队列：" + message);
        rabbitTemplate.convertAndSend("X","XB","消息来自TTL为40s的队列：" + message);

        log.info("当前时间：{}，发送一条消息：{} 给两个TTL队列",new Date().toString(),message);  //{}占位符
    }

    //开始发消息
    @GetMapping("/sendExpirationMsg/{message}/{ttlTime}")
    public void sendMsg(@PathVariable String message,@PathVariable String ttlTime){
        log.info("当前时间：{}，发送一条时长{}毫秒TTL信息给队列QC：{}",
                new Date().toString(),ttlTime,message);
        rabbitTemplate.convertAndSend("X","XC",message,msg->{
            //发送消息的时候 延迟时长
            msg.getMessageProperties().setExpiration(ttlTime);
            return msg;
        });
    }

    //开始发消息 基于插件的 消息 及 延迟的时间
    @GetMapping("/sendDelayMsg/{message}/{delayTime}")
    public void sendMsg(@PathVariable String message,@PathVariable Integer delayTime){
        log.info("当前时间：{}，发送一条时长{}毫秒信息给延迟队列delayed.queue：{}",
                new Date().toString(),delayTime,message);
        rabbitTemplate.convertAndSend(DelayedQueueConfig.DELAYED_EXCHANGE_NAME
                ,DelayedQueueConfig.DELAYED_ROUTING_KEY,message,msg -> {
                    // 发送消息的时候 延迟时长 单位ms
                    msg.getMessageProperties().setDelay(delayTime);
                    return msg;
                });
    }


    //开始发消息，测试确认 ->模拟 交换机跑不通的情况
    //另起一类，见ProducerController





}
