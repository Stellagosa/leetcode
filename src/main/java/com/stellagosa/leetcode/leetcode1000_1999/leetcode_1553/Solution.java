package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1553;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stellagosa
 * @description 吃掉N个橘子的最少天数
 * @date 2024/5/12 19:39 星期日
 */
public class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    public int minDays(int n) {
        if (n < 2) return n;
        if (map.get(n) != null) return map.get(n);
        map.put(n, 1 + Math.min(minDays(n / 2) + (n % 2), minDays(n / 3) + (n % 3)));
        return map.get(n);
    }

    // 超内存
    // public int minDays(int n) {
    //     int[] dp = new int[n + 1];
    //     dp[0] = 0;
    //     dp[1] = 1;
    //
    //     for (int i = 2; i <= n; i++) {
    //         if (i % 2 != 0 && i % 3 != 0) {
    //             dp[i] = dp[i - 1];
    //         } else if (i % 2 == 0 && i % 3 == 0) {
    //             dp[i] = Math.min(dp[i / 2], dp[i / 3]) + 1;
    //         } else if (i % 2 == 0) {
    //             dp[i] = Math.min(dp[i / 2], dp[i - 1]) + 1;
    //         } else {
    //             dp[i] = Math.min(dp[i / 3], dp[i - 1]) + 1;
    //         }
    //     }
    //     return dp[n];
    // }

    // 严重超时
    // public int minDays(int n) {
    //     if (n < 2) return n;
    //
    //     if (n % 2 != 0 && n % 3 != 0) {
    //         return minDays(n - 1) + 1;
    //     }
    //     if (n % 2 == 0 && n % 3 == 0) {
    //         return Math.min(Math.min(minDays(n / 2), minDays(n / 3)), minDays(n - 1)) + 1;
    //     }
    //     if (n % 2 == 0) {
    //         return Math.min(minDays(n / 2), minDays(n - 1)) + 1;
    //     }
    //     return Math.min(minDays(n / 3), minDays(n - 1)) + 1;
    // }

}
