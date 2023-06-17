package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1254;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/18 7:05
 * @Description: 统计封闭岛屿的数目
 */
public class Solution {

    int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // 先覆盖四条边的0
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) dp(grid, i, 0);
            if (grid[i][n - 1] == 0) dp(grid, i, n - 1);
        }

        for (int i = 0; i < n; i++) {
            if (grid[0][i] == 0) dp(grid, 0, i);
            if (grid[m - 1][i] == 0) dp(grid, m - 1, i);
        }

        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    result++;
                    dp(grid, i, j);
                }
            }
        }
        return result;
    }

    private void dp(int[][] grid, int x, int y) {
        if (grid[x][y] == 0) {
            grid[x][y] = -1;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    dp(grid, newX, newY);
                }
            }
        }
    }

}
