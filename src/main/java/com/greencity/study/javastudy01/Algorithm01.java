package com.greencity.study.javastudy01;

public class Algorithm01 {
    public static void main(String[] args) {

        //古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
        // 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？

        int rabbit1 =1;
        int rabbit2 =1;
        int rabbit3;
        int month=30;
        System.out.println(rabbit1);
        System.out.println(rabbit2);
        for (int i = 3; i < month; i++) {
            rabbit3 = rabbit2;
            rabbit2 = rabbit1 + rabbit2;
            rabbit1 = rabbit3;
            System.out.println(rabbit2 );
        }
    }
}
