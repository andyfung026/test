package com.greencity.study.javastudy0517;

public class TernaryIfElse {
    static int ternary(int i) {
        //三元运算符   如果为true  运算i*100  如果为false 运算 i*10
        return i < 10 ? i * 100 : i * 10;
    }

    static int standardIfElse(int i) {
        if (i < 10) {
            return i * 100;
        }else {
            return i * 10;
        }
    }

    public static void main(String[] args) {
        System.out.println(ternary(9));
        System.out.println(ternary(11));
        System.out.println(standardIfElse(9));
        System.out.println(standardIfElse(11));
    }
}
