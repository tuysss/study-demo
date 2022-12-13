package com.tuysss.springbootrabbitmq.controller;

import com.tuysss.springbootrabbitmq.config.ConfirmConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2022-12-12
 *
 * @Author tianyanning <tianyanning@kuaishou.com>
 * @Description 高级确认发布之 开始发消息，测试确认
 *              后续将模拟消息丢失due to路由及之前失效
 *
 */
@Slf4j
@RestController
@RequestMapping("/confirm")
public class ProducerController {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    //发消息
    @GetMapping("/sendMessage/{message}")
    public void sendMessage(@PathVariable String message){

        rabbitTemplate.convertAndSend(ConfirmConfig.CONFIRM_EXCHANGE_NAME,
                ConfirmConfig.CONFIRM_ROUTING_KEY,message);

        log.info("发送消息内容为："+message);

    }





}
