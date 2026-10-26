package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3619;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Stellagosa
 * @description 3619.总价值可以被k整除的岛屿数目
 * @date 10/26/2026 10:09 AM Monday
 */
public class Solution {

    public static void main(String[] args) {
        int[][] grid = {{0,0,1,0},{18,2,20,20},{0,4,5,0},{0,0,0,0}};
        Solution solution = new Solution();
        solution.countIslands(grid, 5);
    }

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    long temp = count(grid, i, j, visited);
                    if (temp % k == 0) ans++;
                }
            }
        }
        return ans;
    }

    // [0,  0, 1, 0],
    // [18, 2, 20,20],
    // [0,  4, 5, 0],
    // [0,  0, 0, 0]
    public long count(int[][] grid, int loc_x, int loc_y, boolean[][] visited) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{loc_x, loc_y});
        visited[loc_x][loc_y] = true;
        long ans = 0;
        while (!queue.isEmpty()) {
            int[] polled = queue.poll();
            ans += grid[polled[0]][polled[1]];
            for (int[] dir : dirs) {
                int next_x = polled[0] + dir[0];
                int next_y = polled[1] + dir[1];
                if (next_x >= 0 && next_x < grid.length
                        && next_y >= 0 && next_y < grid[0].length
                        && !visited[next_x][next_y] && grid[next_x][next_y] > 0) {
                    queue.add(new int[]{next_x, next_y});
                    visited[next_x][next_y] = true;
                }
            }
        }
        return ans;
    }

}
