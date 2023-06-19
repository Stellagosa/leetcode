package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1262;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/19 8:53
 * @Description: 可被三整除的最大和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 6, 5, 1, 8};
        System.out.println(solution.maxSumDivThree(nums));
    }

    public int maxSumDivThree(int[] nums) {
        int[] arr1 = new int[3];
        int n = nums.length;
        for (int num : nums) {
            int[] arr2 = new int[3];
            for (int i = 0; i < 3; i++) {
                arr2[i] = arr1[i];
            }
            for (int j = 0; j < 3; j++) {
                arr2[(arr1[j] + num) % 3] = Math.max(arr2[(arr1[j] + num) % 3], arr1[j] + num);
            }
            arr1 = arr2;
        }
        return arr1[0];
    }

//    public int maxSumDivThree(int[] nums) {
//        int n = nums.length;
//        // dp[i][j]表示前i个数的和除以3余数为j的最大值
//        int[][] dp = new int[n + 1][3];
//
//        for (int i = 1; i <= n; i++) {
//            for (int j = 0; j < 3; j++) {
//                dp[i][j] = dp[i - 1][j];
//            }
//            for (int j = 0; j < 3; j++) {
//                int temp = dp[i - 1][j] + nums[i - 1];
//                dp[i][temp % 3] = Math.max(dp[i][temp % 3], temp);
//            }
//        }
//        return dp[n][0];
//    }
}
