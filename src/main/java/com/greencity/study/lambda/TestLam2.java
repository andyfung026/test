package com.greencity.study.lambda;

public class TestLam2 {
    public static void main(String[] args) {
        Method method = new Method() {
            public void testOne(A a) {
                a.m1();
            }
        };

        //Method m1 = (A a) -> a.m1();
        Method m2 = A::m1;

    }
}

interface Method {
    void testOne(A a);
}

class A {
    public void m1() {
    }

    ;

    public void m2(String str1) {

    }

    public void m3(String str1, String str2) {

    }
}
