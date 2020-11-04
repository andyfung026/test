package com.greencity.study.javaarithmetic;



public class PublicPerfix {
    //编写一个函数来查找字符串数组中的最长公共前缀。
    //如果不存在公共前缀，返回空字符串 ""。
    //["flower","flow","flight"]
    public String publicPer(String [] string) {
        if (string == null) {
            return null;
        }
        String s1= string[0];
        for (int i = 0; i < string.length; i++) {
            while (string[i].indexOf(s1) != 0) {
                s1 = s1.substring(0, string.length - 1);
                if (s1.length() == 0) {
                    return "";
                }
            }
        }
        return s1;
    }

    public static void main(String[] args) {
        PublicPerfix publicPerfix = new PublicPerfix();
        String[] strings = {"flower","flow","flight"};
        String s = publicPerfix.publicPer(strings);
        System.out.println(s);
    }
}
