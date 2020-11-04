package com.greencity.study.javastudy0517;

public class ShortCircuit {
    static boolean test1(int val) {
        System.out.println("test1(" + val + ")");
        System.out.println("result: " + (val < 1));
        return val < 1;
    }

    static boolean test2(int val) {
        System.out.println("test2(" + val + ")");
        System.out.println("result:" + (val < 2));
        return val < 2;
    }

    static boolean test3(int val) {
        System.out.println("test3(" + val + ")");
        System.out.println("result:" + (val < 3));
        return val < 3;
    }

    public static void main(String[] args) {

        //在测试test1时为true 继续  到了test2 时返回的false 这是整个表达式就为false ，没有必要往下
        //计算剩余的表达式，会造成浪费，这就是短路。
        //实际上有一部分表达式不用计算，那将会获得潜在的性能提升
        boolean b = test1(0) && test2(2) && test3(3);
        System.out.println("expression is " + b);
    }
}
