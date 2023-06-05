package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1289;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/5 上午 10:14
 * @Description: 下降路径最小和Ⅱ
 */
public class Solution {

    public int minFallingPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 查找第一行最小值和次小值，并保存所在列数
        // 注意：最小值和次小值有可能相等
        int minNumIndex = 0;
        int minNum = Integer.MAX_VALUE;
        int secondMinNum = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (grid[0][i] < secondMinNum) {
                if (grid[0][i] < minNum) {
                    secondMinNum = minNum;
                    minNum = grid[0][i];
                    minNumIndex = i;
                } else {
                    secondMinNum = grid[0][i];
                }
            }
        }

        for (int i = 1; i < m; i++) {
            int curRowMinNum = Integer.MAX_VALUE;
            int curRowMinNumIndex = 0;
            int curRowSecondMinNum = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                if (j != minNumIndex) {
                    grid[i][j] += minNum;
                } else {
                    grid[i][j] += secondMinNum;
                }

                if (grid[i][j] < curRowSecondMinNum) {
                    if (grid[i][j] < curRowMinNum) {
                        curRowSecondMinNum = curRowMinNum;
                        curRowMinNum = grid[i][j];
                        curRowMinNumIndex = j;
                    } else {
                        curRowSecondMinNum = grid[i][j];
                    }
                }
            }
            minNum = curRowMinNum;
            minNumIndex = curRowMinNumIndex;
            secondMinNum = curRowSecondMinNum;
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(grid[m - 1][i], result);
        }
        return result;
    }


    // 时间复杂度 O(n^3)
//    public int minFallingPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//
//        for (int i = 1; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                // 查找上一行非同列最小值
//                int min = Integer.MAX_VALUE;
//                for (int k = 0; k < n; k++) {
//                    if (k != j && grid[i - 1][k] < min) {
//                        min = grid[i - 1][k];
//                    }
//                }
//                grid[i][j] += min;
//            }
//        }
//        int result = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            result = Math.min(grid[m - 1][i], result);
//        }
//        return result;
//    }
}
