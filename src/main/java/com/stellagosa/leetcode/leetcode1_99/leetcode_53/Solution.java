package com.stellagosa.leetcode.leetcode1_99.leetcode_53;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/8 15:04
 * @Description: 最大子数组和
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }
        return max;
    }
}
