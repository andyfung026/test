package com.greencity.study.javastudy0525.applicationevent;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义一个事件  继承ApplicationEvent
 */
public class DemoEvent extends ApplicationEvent {
    private static final long serialVersionUID = 1L;

    //定义一个事件的属性
    private String msg;


    public DemoEvent(Object source,String msg) {
        super(source);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
