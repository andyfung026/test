package com.greencity.study.javastudy22128;

import java.util.HashMap;
import java.util.Map;

public class RepeatString {
    public static void main(String[] args) {
        RepeatString repeatString = new RepeatString();
        Map<String, Integer> data = repeatString.repeat("abcabcaa");
        System.out.println(data);
    }

    public Map<String, Integer> repeat(String string) {

        //abcabcbb
        char c = 0;
        String s = null;
        String s2 = null;
        Map<String, Integer> result = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            char realChar = string.charAt(i);
            if (realChar == c) {
                result.put(String.valueOf(realChar), 1);
                return result;
            }
            //不相等记录
            if (i == 0) {
                c = realChar;
                continue;
            }
            s = s + String.valueOf(c) + String.valueOf(realChar);

            System.out.println(s);
        }

        return result;
    }
}
