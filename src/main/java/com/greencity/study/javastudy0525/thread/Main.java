package com.greencity.study.javastudy0525.thread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskExecutorConfig.class);

        AsyncTaskService bean = context.getBean(AsyncTaskService.class);
        for (int i = 0; i <= 50; i++) {
            bean.executeAsyncTask(i);
            bean.executeAsyncTaskPlus(i);
        }
        context.close();
    }
}
