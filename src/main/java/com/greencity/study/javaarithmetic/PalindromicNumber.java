package com.greencity.study.javaarithmetic;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class PalindromicNumber {
    public static void main(String[] args) {
        //判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
        System.out.println("请输入整数");
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        PalindromicNumber palindromicNumber = new PalindromicNumber();
        boolean number = palindromicNumber.number(i);
        System.out.println(number);
    }
    private  boolean number(int number) {
//        String str = String.valueOf(number);
//        char[] chars = str.toCharArray();
//        ArrayList<Object> objects = new ArrayList<>();
//        ArrayList<Object> objects1 = new ArrayList<>();
//        if (number<0) {
//            System.out.println("请输入正整数");
//            return false;
//        }
//        for (int j = 0; j < str.length(); j++) {
//            char c = str.charAt(j);
//            objects.add(j, c);
//        }
//        for (int j =chars.length-1 ; j >=0 ; j--) {
//            objects1.add(chars[j]);
//        }
//        if (objects.equals(objects1)) {
//            System.out.println("是回文数");
//            return true;
//        }
//        System.out.println("不是回文数");
//        return false;


        if(number < 0){
            return false;
        }
        int cur = 0;
        int num = number;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == number;

    }
}


