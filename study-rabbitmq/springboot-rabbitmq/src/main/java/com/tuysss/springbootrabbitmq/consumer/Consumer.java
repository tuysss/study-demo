package com.tuysss.springbootrabbitmq.consumer;

import com.tuysss.springbootrabbitmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created on 2022-12-12
 *
 * @Author tianyanning <tianyanning@kuaishou.com>
 * @Description 高级确认发布之 接收消息
 */
@Slf4j
@Component
public class Consumer {

    @RabbitListener(queues = ConfirmConfig.CONFIRM_QUEUE_NAME)
    public void receiveConfirmMessage(Message message){
        String msg=new String(message.getBody());
        log.info("接收到的队列 confirm queue消息：{}",msg);
    }

}
