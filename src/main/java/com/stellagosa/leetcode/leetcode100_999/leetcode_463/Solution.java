package com.stellagosa.leetcode.leetcode100_999.leetcode_463;

/**
 * @author Stellagosa
 * @description 岛屿的周长
 * @date 2026/2/26 12:14 星期四
 */
public class Solution {

    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    if (i - 1 < 0 || grid[i - 1][j] == 0) {
                        perimeter++;
                    }
                    if (i + 1 >= grid.length || grid[i + 1][j] == 0) {
                        perimeter++;
                    }
                    if (j - 1 < 0 || grid[i][j - 1] == 0) {
                        perimeter++;
                    }
                    if (j + 1 >= grid[0].length || grid[i][j + 1] == 0) {
                        perimeter++;
                    }
                }
            }
        }
        return perimeter;
    }
}
