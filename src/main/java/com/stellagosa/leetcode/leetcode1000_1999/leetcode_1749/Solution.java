package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1749;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/8 16:25
 * @Description: 任意子数组和的绝对值的最大值
 */
public class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int preMax = 0;
        int preMin = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            preMax = Math.max(preMax + num, num);
            max = Math.max(max, preMax);
            preMin = Math.min(preMin + num, num);
            min = Math.min(min, preMin);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}
