package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1674;
/**
 * @author Stellagosa
 * @description 使数组互补的最少操作次数
 * @date 2026/5/13 16:00 Wednesday
 */
public class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;
        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {
            int a = Math.min(nums[i], nums[n - i - 1]);
            int b = Math.max(nums[i], nums[n - i - 1]);

            diff[2] += 2;
            diff[a + 1] -= 2;

            diff[a+1]++;
            diff[a+b]--;

            diff[a+b+1]++;
            diff[b+limit+1]--;

            diff[b+limit+1] += 2;
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            sum += diff[i];
            min = Math.min(min, sum);
        }
        return min;
    }
}
