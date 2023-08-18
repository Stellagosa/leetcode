package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1388;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/18 7:30
 * @Description: 3n块披萨
 */
public class Solution {

    public int maxSizeSlices(int[] slices) {
        int n = slices.length;
        int[] src1 = new int[n - 1];
        int[] src2 = new int[n - 1];
        System.arraycopy(slices, 0, src1, 0, n - 1);
        System.arraycopy(slices, 1, src2, 0, n - 1);
        int ans1 = dfs(src1);
        int ans2 = dfs(src2);
        return Math.max(ans1, ans2);
    }

    private int dfs(int[] slices) {
        int n = slices.length;
        int k = (n + 1) / 3;
        int[][] dp = new int[n][k + 1];
        dp[0][0] = 0;
        dp[0][1] = slices[0];
        dp[1][0] = 0;
        dp[1][1] = Math.max(slices[0], slices[1]);

        for (int i = 2; i < n; ++i) {
            for (int j = 1; j <= k; ++j) {
                dp[i][j] = Math.max(dp[i - 2][j - 1] + slices[i], dp[i - 1][j]);
            }
        }
        return dp[n - 1][k];
    }

}
