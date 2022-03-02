package com.greencity.study.javastudy22128;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Long startTime = System.currentTimeMillis();


        Solution solution = new Solution();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(9);
        integers.add(9);
        integers.add(9);
        integers.add(9);
        integers.add(9);
        integers.add(9);
        integers.add(9);
        ArrayList<Integer> integerArrayList2 = new ArrayList<>();
        integerArrayList2.add(9);
        integerArrayList2.add(9);
        integerArrayList2.add(9);
        integerArrayList2.add(9);
        List<Integer> s = solution.solutionMethod(integers, integerArrayList2);

        System.out.println(s);
        Long endTime = System.currentTimeMillis();
        System.out.println("花费时间" + (endTime - startTime) + "ms");
    }
    private List<Integer> solutionMethod(List<Integer> l1, List<Integer> l2) {
        //243
        //564
        //807
        String str1;
        String str2;
        String s1="";
        String s2="";
        for (int i = l1.size(); i > 0; i--) {
            Integer integer = l1.get(i - 1);
            str1 = integer.toString();
            str1 = s1+str1;
            s1 = str1;

        }
        for (int i = l2.size(); i > 0; i--) {
            Integer integer = l2.get(i - 1);
            str2 = integer.toString();
            str2 = s2+str2;
            s2 = str2;

        }
        Integer integer = Integer.valueOf(s1);
        Integer integer1 = Integer.valueOf(s2);
        int i=integer + integer1;
        ArrayList<Integer> objects = new ArrayList<>();
        while(i>0){
            int a  = i%10;
            //System.out.print(a+" ");
            objects.add(a);
            i = i/10;
        }
        return objects;
    }
}
