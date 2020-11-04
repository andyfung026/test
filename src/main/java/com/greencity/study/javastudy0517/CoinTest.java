package com.greencity.study.javastudy0517;

import java.util.Random;

public class CoinTest {
    public static void main(String[] args) {

        //模拟扔硬币的结果

        //要有一个硬币

        Random coin = new Random();
        int i = coin.nextInt(10);
        int j = coin.nextInt(10);

        //如果是正面就返回一个true 如果是反面就返回false
        if (i>j) {
            System.out.println("正面");
        }
        if (i<j) {
            System.out.println("反面");
        }
        if (i == j) {
            System.out.println("硬币立着");
        }
    }
}