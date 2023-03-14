package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1605;

/**
 * @Author: Stellagosa
 * @Date: 2023/3/14 9:56
 * @Description: 给定行和列的和求可行矩阵
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] rowSum = {3,8};
        int[] colSum = {4,7};
        int[][] matrix = solution.restoreMatrix(rowSum, colSum);
        for (int[] nums : matrix) {
            for (int num : nums) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;

        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = Math.min(rowSum[i], colSum[j]);
                res[i][j] = min;
                rowSum[i] -= min;
                colSum[j] -= min;
                if (rowSum[i] == 0) break;
            }
        }
        return res;
    }
}
