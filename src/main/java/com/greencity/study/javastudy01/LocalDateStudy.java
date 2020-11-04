package com.greencity.study.javastudy01;

import java.time.DayOfWeek;
import java.time.LocalDate;

/*
    2020.5.6
    AndyFung
    wednesday
 */
public class LocalDateStudy {
    public static void main(String[] args) {
        //构造一个新的对象，表示构造这个对象的日期
        LocalDate now = LocalDate.now();
        System.out.println(now);


        //可以提供年月日来构造一个特定的日期对象
        LocalDate of = LocalDate.of(2020, 5, 6);
        System.out.println(of);
        //一但有了 localDate 对象，可以用方法getYear,getMounthValue,getDayOfMonth,来得到年月日
        int year = of.getYear();
        int monthValue = of.getMonthValue();
        int dayOfMonth = of.getDayOfMonth();
        System.out.println(year + "," + monthValue + "," + dayOfMonth);


        //plusDays 会得到一个新的LocalDate ，类对外提供的方法
        LocalDate localDate = of.plusDays(1000);
        int year1 = localDate.getYear();
        int monthValue1 = localDate.getMonthValue();
        int dayOfMonth1 = localDate.getDayOfMonth();
        System.out.println(year1+","+monthValue1+","+dayOfMonth1);

        System.out.println("-----------------------------------");

        //打印当前月份日历

        LocalDate date = LocalDate.now();
        //获得当前的月和日;
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        //将date设置为这个月的第一天，并得到这一天是星期几
        date = date.minusDays(today - 1);
        DayOfWeek weekDay = date.getDayOfWeek();
        int value = weekDay.getValue();
        System.out.println("MON TUE WED THU FRI STA SUN");
        for (int i = 1; i < value; i++)
            System.out.print("    ");
        while (date.getMonthValue() == month) {
            System.out.printf("%3d",date.getDayOfMonth());
            if (date.getDayOfMonth() == today)
                System.out.print("*");
            else
                System.out.print(" ");
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue()==1) System.out.println();
        }
        if(date.getDayOfWeek().getValue()!=1) System.out.println();


    }



}




