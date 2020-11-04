package com.greencity.study.javaarithmetic;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        //输入三个整数x,y,z，请把这三个数由小到大输出。
        System.out.println("请输入三个数 ");
        Scanner scanner = new Scanner(System.in);
        System.out.println("第一个数");
        int i = scanner.nextInt();
        System.out.println("第二个数");
        int i1 = scanner.nextInt();
        System.out.println("第三个数");
        int i2 = scanner.nextInt();
        int t = 0;
        if (i > i1) {
            t = i;
            i = i1;
            i1 = t;
        }
        if (i1 > i2) {
            t = i2;
            i2 = i1;
            i1 = t;
        }
        if (i > i1) {
            t = i;
            i = i1;
            i1 = t;
        }
        System.out.println(i+""+i1+""+i2);
    }
}
