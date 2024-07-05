package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3033;

/**
 * @author Stellagosa
 * @description 修改矩阵
 * @date 2024/7/5 8:36 星期五
 */
public class Solution {

    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                max = Math.max(max, matrix[j][i]);
            }
            arr[i] = max;
        }

        int[][] answer = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    answer[i][j] = arr[j];
                } else {
                    answer[i][j] = matrix[i][j];
                }
            }
        }
        return answer;
    }


}
