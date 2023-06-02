package com.stellagosa.leetcode.leetcode1_99.leetcode_62;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/2 下午 05:39
 * @Description: 不同路径
 */
public class Solution {

    // 杨辉三角
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    // 超时
//    public int uniquePaths(int m, int n) {
//        if (m == 1 || n == 1) return 1;
//        return uniquePaths(m, n - 1) + uniquePaths(m - 1, n);
//    }

}
