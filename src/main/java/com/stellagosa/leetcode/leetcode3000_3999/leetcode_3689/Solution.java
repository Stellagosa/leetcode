package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3689;

/**
 * @author Stellagosa
 * @description 最大子数组总值Ⅰ
 * @date 6/9/2026 10:32 AM June
 */
public class Solution {

    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }
        return (long) k * (max - min);
    }

}
