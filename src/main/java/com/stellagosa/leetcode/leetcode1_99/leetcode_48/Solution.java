package com.stellagosa.leetcode.leetcode1_99.leetcode_48;

/**
 * @author Stellagosa
 * @description 旋转图像
 * @date 2026/5/4 9:29 星期一
 */
public class Solution {

    /**
     * 顺时针旋转90°
     * matrix[i,j] -> matrix[j,n-i-1]
     * 观察 i、j 位置调换，然后 i 变成逆序
     * 也就是 矩阵转置+水平镜像
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }


    /**
     * 任意一个位置（i,j）旋转90度后的位置是（j,n-i-1）
     * 4个数轮换，这4个数的位置是
     * (i,j),(j,n-i-1),(n-i-1,n-j-1),(n-j-1,i)
     * matrix[i,j] ∈ [-1000,1000]
     * 旋转后 matrix的值加10000，作为标志，最后遍历减去10000
     * @param matrix 原数组
     */
    // public void rotate(int[][] matrix) {
    //     int n = matrix.length;
    //     int flag = 10000;
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             if (matrix[i][j] <= -1000 + flag) {
    //                 int temp = matrix[i][j];
    //                 matrix[i][j] = matrix[n - j - 1][i] + flag;
    //                 matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1] + flag;
    //                 matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1] + flag;
    //                 matrix[j][n - i - 1] = temp + flag;
    //             }
    //         }
    //     }
    //
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 0; j < n; j++) {
    //             matrix[i][j] -= flag;
    //         }
    //     }
    // }

}
