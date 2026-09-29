package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2267;

/**
 * @author Stellagosa
 * @description 2267.检查是否有合法括号字符串路径
 * @date 9/29/2026 7:11 AM Tuesday
 */
public class Solution {

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int pathLen = m + n - 1;
        // 括号成对出现，奇数个肯定不合法
        if (pathLen % 2 != 0) return false;
        // 起始应该是'('，结尾是')'
        if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
        // 总共pathLen个括号，最大值就是 pathLen/2
        boolean[][][] visited = new boolean[m][n][(pathLen / 2) + 1];
        return dfs(grid, visited, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, boolean[][][] visited, int x, int y, int c) {
        int m = grid.length;
        int n = grid[0].length;

        c += grid[x][y] == '(' ? 1 : -1;
        // 当前位置左括号少于右括号数
        if (c < 0) return false;

        // 到达最后位置
        if (x == m - 1 && y == n - 1) {
            return c == 0;
        }
        // 当前'('数大于剩余括号总数
        if (c > m - x + n - y - 2) return false;
        // 带着参数c到达过(x,y)这个位置，但是程序没结束，说明
        if (visited[x][y][c]) return false;

        visited[x][y][c] = true;
        return (x + 1 < m && dfs(grid, visited, x + 1, y, c)) || (y + 1 < n && dfs(grid, visited, x, y + 1, c));
    }

    // bfs
    // public boolean hasValidPath(char[][] grid) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     int pathLen = m + n - 1;
    //     // 括号成对出现，奇数个肯定不合法
    //     if (pathLen % 2 != 0) return false;
    //     // 起始应该是'('，结尾是')'
    //     if (grid[0][0] == ')' || grid[m - 1][n - 1] == '(') return false;
    //
    //     boolean[][][] dp = new boolean[m][n][pathLen + 1];
    //
    //     dp[0][0][1] = true;
    //
    //     for (int i = 0; i < m; i++) {
    //         for (int j = 0; j < n; j++) {
    //             int change = grid[i][j] == '(' ? 1 : -1;
    //             if (i > 0) {
    //                 for (int k = 0; k <= pathLen; k++) {
    //                     if (dp[i - 1][j][k]) {
    //                         int next = k + change;
    //                         if (next >= 0) {
    //                             dp[i][j][next] = true;
    //                         }
    //                     }
    //                 }
    //             }
    //             if (j > 0) {
    //                 for (int k = 0; k <= pathLen; k++) {
    //                     if (dp[i][j - 1][k]) {
    //                         int next = k + change;
    //                         if (next >= 0) {
    //                             dp[i][j][next] = true;
    //                         }
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return dp[m - 1][n - 1][0];
    // }
}
