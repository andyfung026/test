package com.greencity.study.javastudy210120;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author AndyFung
 * @version 1.0
 * @date 2021/1/20/020 14:27
 * <p>
 * 螺旋矩阵
 * 给定一个包含m*n个元素的矩阵，请按照顺时针螺旋顺序，返回矩阵中所有的元素。
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arrayList = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}};
        List<Integer> integers = solution.spiralOrder(arrayList);
        System.out.println(integers);
    }


    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();
        ArrayList<Integer> three = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int number = matrix.length;
                int times = number - 2;
                if (i == 0) {
                    one.add(matrix[i][j]);
                }

                if (times != 0) {
                    for (int k = 0; k < times; k++) {
                        if (j == matrix[i].length - 1) {
                            one.add(matrix[i][j]);
                        }
                    }
                }
                if (i == 1 && j != matrix[i].length - 1) {
                    three.add(matrix[i][j]);
                }
                if (i == 2) {
                    two.add(matrix[i][j]);
                }
            }
        }
        Collections.reverse(two);
        one.addAll(two);
        one.addAll(three);
        return one;
    }
}
