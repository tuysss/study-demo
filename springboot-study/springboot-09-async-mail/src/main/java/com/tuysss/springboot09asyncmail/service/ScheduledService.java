package com.tuysss.springboot09asyncmail.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //在一个特定的时间执行这个方法
    //CRON表达式： 秒 分 时 日 月 周几
    @Scheduled(cron = "0 1 19 * * ?")
    public void hello(){
        System.out.println("hello,你被执行了");
    }
}
