package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2656;

/**
 * @author Stellagosa
 * @description K个元素的最大和
 * @date 2023/11/15 13:44 星期三
 */
public class Solution {

    public int maximizeSum(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return (k * (max << 1) + k * (k - 1)) >> 1;
    }

}
