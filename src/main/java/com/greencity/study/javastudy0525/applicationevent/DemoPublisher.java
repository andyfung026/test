package com.greencity.study.javastudy0525.applicationevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件发布类
 */
@Component
public class DemoPublisher {

    //注入applicationContext  用来发布事件
    @Autowired
    ApplicationContext applicationContext;

    public void publish(String msg) {
        //使用applicationContext中publishEvent方法来发布消息
        applicationContext.publishEvent(new DemoEvent(this, msg));
    }
}
