package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3702;

/**
 * @author Stellagosa
 * @description 3702.按位异或非零的最长子序列
 * @date 8/15/2026 8:03 AM Saturday
 */
public class Solution {

    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        boolean is_all_zero = true;
        int res = 0;

        for (int i = 0; i < n; i++) {
            res ^= nums[i];
            if (is_all_zero) {
                is_all_zero = nums[i] == 0;
            }
        }

        if (is_all_zero) return 0;
        if (res == 0) return n - 1;
        return n;
    }
}
