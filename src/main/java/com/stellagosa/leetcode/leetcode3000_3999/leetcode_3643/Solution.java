package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3643;

/**
 * @author Stellagosa
 * @description 垂直翻转子矩阵
 * @date 2026/3/21 15:59 星期六
 */
public class Solution {

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i1 = x, i2 = x + k - 1; i1 < i2; i1++, i2--) {
            for (int j = y; j < k + y; j++) {
                int temp = grid[i1][j];
                grid[i1][j] = grid[i2][j];
                grid[i2][j] = temp;
            }
        }
        return grid;
    }

}
