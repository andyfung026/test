package com.greencity.study.javastudy0525.taskscheduler;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("com.greencity.study.javastudy0525.taskscheduler")
@EnableScheduling//开启对计划任务的支持
//配置类
public class TaskSchedulerConfig {

}
