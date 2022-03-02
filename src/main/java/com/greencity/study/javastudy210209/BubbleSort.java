package com.greencity.study.javastudy210209;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2021/2/9/009 10:26
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] a = {8,5, 6,4, 3, 9, 2, 1, 7};

        for (int i = 0; i < a.length; i++) {
            for (int j = 1; j < a.length  - i; j++) {
                if (a[j - 1] > a[j]) {
                    int tmp = a[j - 1];
                    a[j - 1] = a[j];
                    a[j] = tmp;
                }
            }
        }
        for (int x : a) {
            System.out.println(x + ",");
        }

    }
}
