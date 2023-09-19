package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2560;

/**
 * @author Stellagosa
 * @description 打家劫舍Ⅳ
 * @date 2023/9/19 8:45 星期二
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(solution.minCapability(nums, 3));
    }

    public int minCapability(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int left = min, right = max;
        while (left <= right) {
            int mid = (left + right) >> 1;
            int count = 0;
            boolean visit = false;
            for (int num : nums) {
                if (num <= mid && !visit) {
                    count++;
                    visit = true;
                } else {
                    visit = false;
                }
                if (count >= k) break;
            }
            if (count >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 内存超出
    // public int minCapability(int[] nums, int k) {
    //     int n = nums.length;
    //     int[][] dp = new int[n][k + 1];
    //
    //     dp[0][1] = nums[0];
    //     for (int i = 1; i < n; i++) {
    //         dp[i][1] = Math.min(dp[i - 1][1], nums[i]);
    //     }
    //     for (int i = 0; i < n; i++) {
    //         for (int j = 2 + (i >> 1); j <= k; j++) {
    //             dp[i][j] = Integer.MAX_VALUE;
    //         }
    //     }
    //     for (int i = 2; i < n; i++) {
    //         for (int j = 2; j <= k && j <= 1 + (i + 1) >> 1; j++) {
    //             dp[i][j] = Math.min(dp[i - 1][j], Math.max(dp[i - 2][j - 1], nums[i]));
    //         }
    //     }
    //     int result = Integer.MAX_VALUE;
    //     for (int i = (k << 1) - 2; i < n; i++) {
    //         result = Math.min(dp[i][k], result);
    //     }
    //     return result;
    // }

}
