package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3101;

/**
 * @author Stellagosa
 * @description 交替子数组计数
 * @date 2024/7/6 9:17 星期六
 */
public class Solution {

    public long countAlternatingSubArrays(int[] nums) {
        long result = 1, dp = 1;
        for (int i = 1; i < nums.length; i++) {
            dp = nums[i] == nums[i - 1] ? 1 : dp + 1;
            result += dp;
        }
        return result;
    }


    // public long countAlternatingSubArrays(int[] nums) {
    //     int n = nums.length;
    //     long result = 0;
    //     if (n < 1) return result;
    //     long dp = 1;
    //     result += dp;
    //     for (int i = 1; i < n; i++) {
    //         if (nums[i] == nums[i - 1]) {
    //             dp = 1;
    //         } else {
    //             dp++;
    //         }
    //         result += dp;
    //     }
    //     return result;
    // }

    // public long countAlternatingSubArrays(int[] nums) {
    //     int n = nums.length;
    //
    //     // dp[i] 表示以nums[i]结尾的交替子数组个数
    //     long[] dp = new long[n];
    //     dp[0] = 1;
    //
    //     for (int i = 1; i < n; i++) {
    //         if (nums[i] == nums[i - 1]) {
    //             dp[i] = 1;
    //         } else {
    //             dp[i] = dp[i - 1] + 1;
    //         }
    //     }
    //     long result = 0;
    //     for (long l : dp) {
    //         result += l;
    //     }
    //     return result;
    // }

}
