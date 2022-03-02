package com.greencity.study.solution;


import java.util.ArrayList;
import java.util.List;

//实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
//
//示例 1：
//
//输入: s = "leetcode"
//输出: false
//示例 2：
//
//输入: s = "abc"
//输出: true
public class SolutionTest {
    public static void main(String[] args) {
        String a = "andy";
        Boolean aBoolean = solutionTestOne(a);
        System.out.println(aBoolean);

    }

    private static Boolean solutionTestOne(String string) {
        List list = new ArrayList();
        char[] cs = string.toCharArray();
        for (char c : cs) {
            if (!list.contains(c)) {
                list.add(c);
            } else {
                return false;
            }
        }
        return true;
    }
}
