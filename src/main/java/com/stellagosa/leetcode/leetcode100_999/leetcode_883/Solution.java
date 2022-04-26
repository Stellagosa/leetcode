package com.stellagosa.leetcode.leetcode100_999.leetcode_883;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2022/4/26 7:56
 * @Description: 三维形体投影面积
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[][] grid = {{1, 2}, {3, 4}};
        int[][] grid = {{2}};
        System.out.println(solution.projectionArea(grid));
    }

    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int[] row = new int[n];
        int[] column = new int[n];
        int s = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = Math.max(row[i], grid[i][j]);
                column[j] = Math.max(column[j], grid[i][j]);
                s += grid[i][j] > 0 ? 1 : 0;
            }
        }

        s += Arrays.stream(row).sum();
        s += Arrays.stream(column).sum();

        return s;
    }
}
