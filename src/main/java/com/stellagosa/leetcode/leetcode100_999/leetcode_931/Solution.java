package com.stellagosa.leetcode.leetcode100_999.leetcode_931;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/3 下午 06:26
 * @Description: 下降路径最小和
 */
public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int minSum = 0;
        if (n == 1) {
            for (int i = 0; i < m; i++) {
                minSum += matrix[i][0];
            }
            return minSum;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]);
                } else if (j == n - 1) {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]);
                } else {
                    matrix[i][j] += Math.min(Math.min(matrix[i - 1][j - 1], matrix[i - 1][j]), matrix[i - 1][j + 1]);
                }
            }
        }

        minSum = matrix[m - 1][0];
        for (int i = 0; i < n; i++) {
            minSum = Math.min(matrix[m - 1][i], minSum);
        }
        return minSum;
    }
}
