package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1402;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 做菜顺序
 * @date 2023/10/22 10:17 星期日
 */
public class Solution {

    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int sum = 0;
        int dp1 = 0, dp2;
        for (int i = n - 1; i >= 0; --i) {
            sum += satisfaction[i];
            dp2 = dp1 + sum;
            if (dp2 < dp1) break;
            dp1 = dp2;
        }
        return dp1;
    }

    // public int maxSatisfaction(int[] satisfaction) {
    //     Arrays.sort(satisfaction);
    //     int n = satisfaction.length;
    //
    //     int[] dp = new int[n + 1];
    //     int sum = 0;
    //     for (int i = n - 1; i >= 0; --i) {
    //         sum += satisfaction[i];
    //         dp[i] = dp[i + 1] + sum;
    //     }
    //
    //     int max = Integer.MIN_VALUE;
    //     for (int num : dp) {
    //         max = Math.max(max, num);
    //     }
    //     return max;
    // }

}
