package com.greencity.study.genericity;

import org.apache.poi.ss.formula.functions.T;

public class MethodTwo {
    public static void main(String[] args) {
        Method<?> stringMethod = new Method<>();
        stringMethod.setName("小黑");
        stringMethod.setAge(19);
        printAll(stringMethod);

    }

    private static void printAll(Method<?> method) {
        System.out.println(method);
    }
}
