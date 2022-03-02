package com.greencity.study.javastudy210119;

import java.util.ArrayList;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2021/1/19/019 14:32
 */

/**
 * 给你一个链表和一个待定值X，请你对链表进行分割，使得所有小于X的节点都出现在大于或等于X的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class Solution {
    public String partition(int[] i, int x) {
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> integers1 = new ArrayList<>();
        for (int j = 0; j < i.length; j++) {
            System.out.println(i[j]);
            if (i[j] < x) {
                integers.add(i[j]);
            } else {
                integers1.add(i[j]);
            }
        }
        System.out.println(integers);
        System.out.println(integers1);
        integers.addAll(integers1);
        System.out.println(integers);
        return null;
    }

    public static void main(String[] args) {
        int[] head = {1, 4, 6, 3, 2, 5, 2, 4, 1};
        int i = 3;
        Solution solution = new Solution();
        String partition = solution.partition(head, i);
        System.out.println(partition);
    }
}





