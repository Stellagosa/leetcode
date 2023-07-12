package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1911;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/12 10:10
 * @Description: 最大子序列交替和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 2, 5, 3};
        long result = solution.maxAlternatingSum(nums);
        System.out.println(result);
    }

    public long maxAlternatingSum(int[] nums) {
        // 偶数结尾的最大子序列和
        long sum0 = 0;
        // 奇数结尾的最大子序列和
        long sum1 = 0;

        for (int num : nums) {
            sum0 = Math.max(sum0, sum1 + num);
            sum1 = Math.max(sum1, sum0 - num);
        }

        return sum0;
    }
}
