package com.stellagosa.leetcode.leetcode100_999.leetcode_807;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/13 10:46
 * @Description: 保持城市天际线
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
        System.out.println(solution.maxIncreaseKeepingSkyline(grid));
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] maxX = new int[m];
        int[] maxY = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxX[i] = Math.max(grid[i][j], maxX[i]);
                maxY[j] = Math.max(grid[i][j], maxY[j]);
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res += Math.min(maxX[i], maxY[j]) - grid[i][j];
            }
        }
        return res;
    }
}
