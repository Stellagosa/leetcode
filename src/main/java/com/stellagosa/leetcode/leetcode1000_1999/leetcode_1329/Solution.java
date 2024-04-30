package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1329;

/**
 * @author Stellagosa
 * @description 将矩阵按对角线排序
 * @date 2024/4/29 8:20 星期一
 */
public class Solution {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        for (int k = 0; k < Math.min(m, n); k++) {
            boolean flag = false;
            for (int i = m - 1; i > 0; i--) {
                for (int j = n - 1; j > 0; j--) {
                    if (mat[i][j] < mat[i - 1][j - 1]) {
                        flag = true;
                        int temp = mat[i - 1][j - 1];
                        mat[i - 1][j - 1] = mat[i][j];
                        mat[i][j] = temp;
                    }
                }
            }
            if (!flag) break;
        }
        return mat;
    }

}
