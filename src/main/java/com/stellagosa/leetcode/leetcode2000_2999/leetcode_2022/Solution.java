package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2022;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/1 0:05
 * @Description: 将一维数组转变成二维数组
 */
public class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) return new int[0][0];
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            // System.arraycopy(original, i * n, res[i], 0, n);
            for (int j = 0; j < n; j++) {
                res[i][j] = original[i * n + j];
            }
        }
        return res;
    }
}
