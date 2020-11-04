package com.greencity.study.javastudy0525.applicationevent;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(EventConfig.class);
        DemoPublisher bean = annotationConfigApplicationContext.getBean(DemoPublisher.class);
        bean.publish("hello application event");
        annotationConfigApplicationContext.close();
    }
}
