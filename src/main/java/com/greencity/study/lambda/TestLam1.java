package com.greencity.study.lambda;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestLam1 {
    public static void main(String[] args) {
        Thread hello = new Thread(() ->
                System.out.println("hello")
        );


        List<String> integers = Arrays.asList("an", "jack", "Tom", "Lisa");
        integers.forEach(System.out::println);

        //对集合进行排序
        integers.sort((i1, i2) -> i1.length() - i2.length());
        integers.forEach(System.out::print);
    }
}
