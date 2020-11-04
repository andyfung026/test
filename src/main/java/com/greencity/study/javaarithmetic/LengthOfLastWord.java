package com.greencity.study.javaarithmetic;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/21/021 16:49
 */

public class LengthOfLastWord {

    /**
     * @param //最后一个单词的长度
     */
    public static void main(String[] args) {
        LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
        String str = "hello world";
        int length = lengthOfLastWord.length(str);
        System.out.println(length);
    }

    /**
     * @param str
     * @return int
     */
    public int length(String str) {
        String[] s = str.split(" ");
        if (s.length <= 1) {
            return 0;
        }
        for (int i = 0; i < s.length; i++) {
            String string = s[0];
            char c = string.charAt(i);
            if (Character.isLowerCase(c)) {
                return 1;
            }
        }
        String s1 = s[s.length-1];
        return s1.length();
    }
}

