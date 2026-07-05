package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1301;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/10 下午 05:23
 * @Description: 最大得分的路径数目
 */
public class Solution {

    int mod = 1000000007;

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> board = new ArrayList<>();
        board.add("E11");
        board.add("XXX");
        board.add("11S");

        solution.pathsWithMaxScore(board);
    }


    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char ch = board.get(i).charAt(j);
                if (ch == 'S') {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 1;
                } else if (ch == 'E') {
                    update(dp, i, j, i + 1, j, n);
                    update(dp, i, j, i, j + 1, n);
                    update(dp, i, j, i + 1, j + 1, n);
                } else if (ch == 'X') {
                    dp[i][j][0] = -1;
                    dp[i][j][1] = -1;
                } else {
                    update(dp, i, j, i + 1, j, n);
                    update(dp, i, j, i, j + 1, n);
                    update(dp, i, j, i + 1, j + 1, n);
                    if (dp[i][j][0] == -1) continue;
                    dp[i][j][0] = (dp[i][j][0] + charToNum(ch)) % 1_000_000_007;
                }
            }
        }

        if (dp[0][0][0] == -1) return new int[]{0, 0};
        return new int[]{dp[0][0][0], dp[0][0][1]};
    }

    private void update(int[][][] dp, int i, int j, int x, int y, int n) {
        if (x >= n || y >= n || dp[x][y][0] == -1) return;
        if (dp[i][j][0] > dp[x][y][0]) return;
        if (dp[i][j][0] == dp[x][y][0]) {
            dp[i][j][1] = (dp[i][j][1] + dp[x][y][1]) % 1_000_000_007;
            return;
        }
        dp[i][j][0] = dp[x][y][0];
        dp[i][j][1] = dp[x][y][1];
    }

    private int charToNum(char ch) {
        if (ch == 'S' || ch == 'E' || ch == 'X') return 0;
        return ch - '0';
    }


    // public int[] pathsWithMaxScore(List<String> board) {
    //     int n = board.size();
    //     char[][] chars = new char[n][n];
    //     for (int i = 0; i < n; i++) {
    //         chars[i] = board.get(i).toCharArray();
    //     }
    //
    //     // 最大路径值
    //     int[][] dp = new int[n][n];
    //     // 最大路径值条数
    //     int[][] nums = new int[n][n];
    //
    //     for (int i = n - 1; i >= 0; i--) {
    //         for (int j = n - 1; j >= 0; j--) {
    //             if (chars[i][j] == 'X') {
    //                 dp[i][j] = 0;
    //                 nums[i][j] = 0;
    //             } else if (i == n - 1 && j == n - 1) {
    //                 dp[i][j] = 0;
    //                 nums[i][j] = 1;
    //             } else if (i == n - 1) {
    //                 dp[i][j] = dp[i][j + 1] + charToNumber(chars[i][j]);
    //                 dp[i][j] %= mod;
    //                 nums[i][j] = nums[i][j + 1];
    //             } else if (j == n - 1) {
    //                 dp[i][j] = dp[i + 1][j] + charToNumber(chars[i][j]);
    //                 dp[i][j] %= mod;
    //                 nums[i][j] = nums[i + 1][j];
    //             } else {
    //                 int temp = Math.max(dp[i + 1][j], dp[i][j + 1]);
    //                 temp = Math.max(dp[i + 1][j + 1], temp);
    //                 dp[i][j] = temp + charToNumber(chars[i][j]);
    //                 dp[i][j] %= mod;
    //                 nums[i][j] += temp == dp[i + 1][j] ? nums[i + 1][j] : 0;
    //                 nums[i][j] %= mod;
    //                 nums[i][j] += temp == dp[i][j + 1] ? nums[i][j + 1] : 0;
    //                 nums[i][j] %= mod;
    //                 nums[i][j] += temp == dp[i + 1][j + 1] ? nums[i + 1][j + 1] : 0;
    //                 nums[i][j] %= mod;
    //             }
    //         }
    //     }
    //     if (nums[0][0] == 0) return new int[]{0, 0};
    //     return new int[]{dp[0][0], nums[0][0]};
    // }
    //
    // private int charToNumber(char ch) {
    //     if (ch == 'S' || ch == 'E' || ch == 'X') return 0;
    //     return ch - '0';
    // }
}
