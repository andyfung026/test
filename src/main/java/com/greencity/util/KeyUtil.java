package com.greencity.util;

import java.util.Random;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/7/8/008 14:54
 */
public class KeyUtil {
    //商城唯一的主键

    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer i = random.nextInt(900000) + 100000;
        return System.currentTimeMillis()+String.valueOf(i);
    }
}
