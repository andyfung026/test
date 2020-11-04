package com.greencity.study.javaarithmetic;

public class test4 {
    public static void main(String[] args) {
        //给定一个含有 n 个正整数的数组和一个正整数 s ，
        // 找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
        // 如果不存在符合条件的连续子数组，返回 0。
        //输入: s = 7, nums = [2,3,1,2,4,3]
        //输出: 2
        //解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。

        int s = 15;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(new test4().minSubArrayLen(s,nums));
    }

    public int minSubArrayLen(int s, int[] nums) {
        boolean flag = true;
        int minOfLength = s;
        int sum=0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= s) {
                flag = false;
                if (i - left + 1 < minOfLength) {
                    minOfLength = i - left + 1;
                }
                sum -= nums[left];
                left++;
            }
        }
        if(flag) return 0;
        return minOfLength;
    }
}
