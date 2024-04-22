package com.stellagosa.leetcode.leetcode100_999.leetcode_377;

/**
 * @author Stellagosa
 * @description 组合总和Ⅳ
 * @date 2024/4/22 10:04 星期一
 */
public class Solution {

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }

}
