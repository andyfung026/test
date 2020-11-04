package com.greencity.study.javastudy0525.applicationevent;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 定义一个事件的监听器   实现ApplicationListener 接口   并定义监听事件的类型
 */
@Component
public class DemoListener implements ApplicationListener<DemoEvent> {

    //使用onApplicationEvent方法对消息进行接受处理
    @Override
    public void onApplicationEvent(DemoEvent demoEvent) {
        String msg = demoEvent.getMsg();

        System.out.println("DemoListener接受到beanpublisher发布的消息" + msg);
    }
}
