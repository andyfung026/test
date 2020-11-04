package com.greencity.study.javastudy0525.taskscheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ScheduledTaskService {

    private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 60000)
    public void reportCurrentTime() {
        System.out.println("每隔一分钟执行一次" + dataFormat.format(new Date()));
    }

    //定时任务注解 cron 固定时间执行一次
    @Scheduled(cron = "0 30 14 ? * *")
    public void fixTimeExecution() {
        System.out.println("两点半执行"+dataFormat.format(new Date())+"执行");
    }
}
