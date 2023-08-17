package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1444;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/17 6:16
 * @Description: 切披萨的方案数
 */
public class Solution {

    public int ways(String[] pizza, int k) {
        int mod = 1000000007;
        int m = pizza.length;
        int n = pizza[0].length();
        // 记录该坐标右下的苹果数
        int[][] apples = new int[m + 1][n + 1];
        // 该坐标右下角切出k块的方案数
        int[][][] dp = new int[k + 1][m + 1][n + 1];

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                apples[i][j] = apples[i + 1][j] + apples[i][j + 1] - apples[i + 1][j + 1] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
                dp[1][i][j] = apples[i][j] > 0 ? 1 : 0;
            }
        }

        for (int ki = 2; ki <= k; ++ki) {
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    // 水平切
                    for (int ii = i + 1; ii < m; ++ii) {
                        // 确保水平切下的一块，也就是上面那一块，至少有一个苹果
                        if (apples[i][j] > apples[ii][j] && apples[ii][j] > 0) {
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][ii][j]) % mod;
                        }
                    }
                    // 垂直切
                    for (int ji = j + 1; ji < n; ++ji) {
                        // 确保左边一块至少一个苹果
                        if (apples[i][j] > apples[i][ji] && apples[i][ji] > 0)
                            dp[ki][i][j] = (dp[ki][i][j] + dp[ki - 1][i][ji]) % mod;
                    }
                }
            }
        }
        return dp[k][0][0];
    }
}
