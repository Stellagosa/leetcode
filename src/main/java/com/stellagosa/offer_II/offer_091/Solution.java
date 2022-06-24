package com.stellagosa.offer_II.offer_091;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/25 5:46
 * @Description: 粉刷房子
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[][] costs = {{17,2,17},{16,16,5},{14,3,19}};
        int[][] costs = {{7, 6, 2}};
        System.out.println(solution.minCost(costs));
    }

    public int minCost(int[][] costs) {
        int[] dp_pre = new int[3];
        int[] dp_next = new int[3];

        for (int[] cost : costs) {
            dp_next[0] = Math.min(dp_pre[1], dp_pre[2]) + cost[0];
            dp_next[1] = Math.min(dp_pre[0], dp_pre[2]) + cost[1];
            dp_next[2] = Math.min(dp_pre[0], dp_pre[1]) + cost[2];
            dp_pre[0] = dp_next[0];
            dp_pre[1] = dp_next[1];
            dp_pre[2] = dp_next[2];
        }
        // 0ms
        return Math.min(Math.min(dp_next[0], dp_next[1]), dp_next[2]);
        // 2ms
        // return Arrays.stream(dp_next).min().getAsInt();
    }
}

// dp(i)(k) 表示[0,i]的房子已被粉刷，结尾颜色是k,花费最小
// dp(0)(0) = costs[0][0]
// dp(0)(1) = costs[0][1]
// dp(0)(2) = costs[0][2]

// dp(1)(0) = min(dp(0)(1),dp(0)(2))+costs[1][0]
// dp(1)(1) = min(dp(0)(0),dp(0)(2))+costs[1][1]
// dp(1)(2) = min(dp(0)(0),dp(0)(1))+costs[1][2]

// dp(2)(0) = min(dp(1)(1),dp(1)(2))+costs[2][0]
// dp(2)(1) = min(dp(1)(0),dp(1)(2))+costs[2][1]
// dp(2)(2) = min(dp(1)(0),dp(1)(1))+costs[2][2]

// dp(3)(0) = min(dp(2)(1),dp(2)(2))+costs[3][0]
// dp(3)(1) = min(dp(2)(0),dp(2)(2))+costs[3][1]
// dp(3)(2) = min(dp(2)(0),dp(2)(1))+costs[3][2]

// dp(i)(0) = min(dp(i-1)(1),dp(i-1)(2))+costs[i][0]
// dp(i)(1) = min(dp(i-1)(0),dp(i-1)(2))+costs[i][1]
// dp(i)(2) = min(dp(i-1)(0),dp(i-1)(1))+costs[i][2]
