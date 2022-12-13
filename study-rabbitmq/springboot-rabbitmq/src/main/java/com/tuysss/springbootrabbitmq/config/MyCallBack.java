package com.tuysss.springbootrabbitmq.config;

import com.rabbitmq.client.ConfirmCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * Created on 2022-12-12
 *
 * @Author tianyanning <tianyanning@kuaishou.com>
 * @Description
 */
@Slf4j
@Component
public class MyCallBack implements RabbitTemplate.ConfirmCallback {

    //把写好的实现类 注入RabbitTemplate类的内部接口ConfirmCallback
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostConstruct
    public void init(){
        //实际的注入流程： @Component实例化 -> @Autowired -> @PostConstruct
        rabbitTemplate.setConfirmCallback(this);
    }



    /**
     * 交换机确认回调方法
     * 交换机确认回调方法,发消息后，交换机接收到了就回调
     *   1.1 correlationData：保存回调消息的ID及相关信息
     *   1.2 b:交换机收到消息，为true
     *   1.3 s:失败原因，成功为null
     *
     * 发消息，交换机接受失败，也回调
     *   2.1 correlationData：保存回调消息的ID及相关信息
     *   2.2 b:交换机没收到消息，为false
     *   2.3 s:失败的原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        String id=correlationData!=null ? correlationData.getId() : "";
        if(ack){
            log.info("交换机已经收到id为：{}的消息",id);
        }else{
            log.info("交换机还未收到id为{}的消息，原因为：{}",id,cause);
        }


    }





}
