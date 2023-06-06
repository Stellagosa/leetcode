package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2352;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/6 上午 08:22
 * @Description: 相等行列对
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{3, 2, 1}, {1, 7, 6}, {2, 7, 7}};
        System.out.println(solution.equalPairs(grid));
    }

    // 暴力
    public int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < n; k++) {
                    if (grid[i][k] != grid[k][j]) {
                        flag = true;
                        break;
                    } else {
                        flag = false;
                    }
                }
                if (!flag) {
                    count++;
                }
            }
        }
        return count;
    }
}
