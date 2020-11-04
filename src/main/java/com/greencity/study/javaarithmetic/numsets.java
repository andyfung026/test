package com.greencity.study.javaarithmetic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2020/8/7/007 17:20
 */
public class numsets {
    public ArrayList<Integer> subset(int[] numbers) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);

            arrayList.add(numbers[i]);
            Integer integer = arrayList.get(i);

        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] i = {1, 2, 3};
        numsets numsets = new numsets();
        ArrayList<Integer> subset = numsets.subset(i);
        System.out.println(subset);
    }
}
