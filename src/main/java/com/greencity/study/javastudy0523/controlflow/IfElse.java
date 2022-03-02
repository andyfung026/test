package com.greencity.study.javastudy0523.controlflow;

public class IfElse {
    static int result = 0;

    static void test(int testval, int target) {
        if (testval > target)
        {
            result = +1;
        }
        else if (testval<target)
        {
            result = -1;
        }
        else {
            result = 0;
        }
    }

    public static void main(String[] args) {
        test(5, 10);
        System.out.println(result);
        test(10, 8);
        System.out.println(result);
        test(4, 4);
        System.out.println(result);

        for (int i = 0; i < 1000000; i++) {
            System.out.println(i);
        }
    }
}
