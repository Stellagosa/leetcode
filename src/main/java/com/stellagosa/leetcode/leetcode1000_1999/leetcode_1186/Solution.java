package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1186;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/27 21:47
 * @Description: 删除一次得到子数组最大和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 1, -2, -5, -2};
        System.out.println(solution.maximumSum(arr));
    }

    // 可以用滚动参数将空间复杂度降为o(1)
    public int maximumSum(int[] arr) {
        int n = arr.length;
        // dp[i][0] 表示不删除元素时，以第i个元素结尾的子数组最大和
        // dp[i][1] 表示删除1个元素时，前第i个元素结尾的子数组最大和
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0];
        int result = dp[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]);
            dp[i][1] = Math.max(dp[i - 1][1] + arr[i], dp[i - 1][0]);
            result = Math.max(dp[i][0], Math.max(dp[i][1], result));
        }
        return result;
    }
}
