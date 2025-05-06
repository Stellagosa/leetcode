package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1920;

/**
 * @author Stellagosa
 * @description 基于排列构建数组
 * @date 2025/5/6 12:30 星期二
 */
public class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
