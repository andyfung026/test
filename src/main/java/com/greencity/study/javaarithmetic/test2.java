package com.greencity.study.javaarithmetic;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        //输入某年某月某日，判断这一天是这一年的第几天？

        int year ,month,day;
        int days = 0;
        int d=0;
        int e;
        Input str = new Input();
        do {
            e = 0;
            System.out.print("输入年:");
            year = str.input();
            System.out.print("输入月:");
            month = str.input();
            System.out.print("输入日:");
            day = str.input();
            //判断输入的是否正确
            if (year < 0 || month < 0 || month > 12 || day < 0 || day > 31) {
                System.out.println("输入有误！,请重新输入");
                e = 1;
            }
        } while (e == 1);


        for (int i = 0; i < month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    days=31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    days=30;
                    break;

                case 2:
                    if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                        days=29;
                    }else {
                        days=28;
                    }
                    break;
                    }
                    d+=days;
            }
        System.out.println(year + "-" + month +"-" + day + "是这年的第" +(d+day) + "天。");
        }
}



class Input{
     int input(){
        int i=0;
        Scanner scanner = new Scanner(System.in);
        i = scanner.nextInt();
        return  i;
    }
}