package com.greencity.study.sendSmsOTP;

import java.util.Random;

public class RandomUtils {
    static String CHARS_TABLE = "23456789ABCDEFGHJKMNPQRSTUVWXYZ";
    static int CHAR_TABLE_LEN = CHARS_TABLE.length();
    static String INT_TABLE = "1234567890";
    static int INT_TABLE_LEN = INT_TABLE.length();

    private static final Random random = new Random();

    public static String randomCaptcha(int len) {
        random.setSeed(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<len; i++) {
            sb.append(CHARS_TABLE.charAt(random.nextInt(CHAR_TABLE_LEN)));
        }
        return sb.toString();
    }

    public static String randomOtp(int len) {
        random.setSeed(System.currentTimeMillis());
        StringBuffer sb = new StringBuffer();
        for (int i=0; i<len; i++) {
            sb.append(INT_TABLE.charAt(random.nextInt(INT_TABLE_LEN)));
        }
        return sb.toString();
    }
}
