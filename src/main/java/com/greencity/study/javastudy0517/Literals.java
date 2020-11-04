package com.greencity.study.javastudy0517;

public class Literals {
    public static void main(String[] args) {
        int i1 = 0x2f;
        System.out.println("i1: " + Integer.toBinaryString(i1));
        int i2 = 0X2f;
        System.out.println("i2: " + Integer.toBinaryString(i2));

        Long n1 = 200L;
        System.out.println("n1: " + Long.toBinaryString(n1));

        double d1 = 100D;
        System.out.println("d1: " + Double.toString(d1));
    }
}
