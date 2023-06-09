package com.stellagosa.leetcode.leetcode100_999.leetcode_576;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/9 下午 02:15
 * @Description: 出界的路径数
 */
public class Solution {

    int mod = 1000000007;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findPaths(8, 50, 23, 5, 26));
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove == 0) return 0;
        // dp[i][j][k] 表示在(i,j)位置恰好移动k次时出界路径数
        int[][][] dp = new int[m][n][maxMove + 1];

        // 四个角则都是2，两个角都是3，只有一个角则是4
        if (m == 1 && n == 1) return maxMove > 0 ? 4 : 0;
        if (m == 1) {
            dp[0][0][1] = 3;
            dp[0][n - 1][1] = 3;
            for (int j = 1; j < n - 1; j++) {
                dp[0][j][1] = 2;
            }
        } else if (n == 1) {
            dp[0][0][1] = 3;
            dp[m - 1][0][1] = 3;
            for (int i = 1; i < m - 1; i++) {
                dp[i][0][1] = 2;
            }
        } else {
            dp[0][0][1] = 2;
            dp[0][n - 1][1] = 2;
            dp[m - 1][0][1] = 2;
            dp[m - 1][n - 1][1] = 2;
            for (int j = 1; j < n - 1; j++) {
                dp[0][j][1] = 1;
                dp[m - 1][j][1] = 1;
            }
            for (int i = 1; i < m - 1; i++) {
                dp[i][0][1] = 1;
                dp[i][n - 1][1] = 1;
            }
        }

        for (int k = 1; k <= maxMove; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j][k] += i - 1 >= 0 ? dp[i - 1][j][k - 1] : 0;
                    dp[i][j][k] %= mod;
                    dp[i][j][k] += i + 1 < m ? dp[i + 1][j][k - 1] : 0;
                    dp[i][j][k] %= mod;
                    dp[i][j][k] += j - 1 >= 0 ? dp[i][j - 1][k - 1] : 0;
                    dp[i][j][k] %= mod;
                    dp[i][j][k] += j + 1 < n ? dp[i][j + 1][k - 1] : 0;
                    dp[i][j][k] %= mod;
                }
            }
        }

        int result = 0;
        for (int i = 0; i <= maxMove; i++) {
            result += dp[startRow][startColumn][i];
            result %= mod;
        }
        return result;
    }
}
