package com.greencity.study.javaarithmetic;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        //输入一串字符串统计出英文，数字，空格，和其他字符的个数
        //输入
        Scanner input = new Scanner(System.in);
        System.out.println("请输入");
        String str = input.nextLine();
        char[] chars = str.toCharArray();
        int english=0;
        int num=0;
        int tes=0;
        int other=0;
        Integer  count =null;
        //定义英文，数字，空格，其他
        for (int i = 0; i < chars.length; i++) {
            char c = str.charAt(i);
            //判断是否有英文
            if (Character.isLetter(chars[i])) {
                english++;
            } else if (Character.isDigit(chars[i])) {
                num++;
            }else if(Character.isSpaceChar(chars[i])){
                tes++;
            }else {
                other++;
            }
        }
        System.out.println(english);
        System.out.println(num);
        System.out.println(tes);
        System.out.println(other);
    }
}
