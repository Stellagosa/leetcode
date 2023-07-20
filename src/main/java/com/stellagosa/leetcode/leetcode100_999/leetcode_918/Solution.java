package com.stellagosa.leetcode.leetcode100_999.leetcode_918;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/20 8:32
 * @Description: 环形子数组的最大和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-3, -2, -3};
        System.out.println(solution.maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int maxCount = Integer.MIN_VALUE;
        int curMaxCount = 0;
        int minCount = Integer.MAX_VALUE;
        int curMinCount = 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            curMaxCount = Math.max(curMaxCount + num, num);
            maxCount = Math.max(curMaxCount, maxCount);
            curMinCount = Math.min(curMinCount + num, num);
            minCount = Math.min(curMinCount, minCount);
        }
        return maxCount < 0 ? maxCount : Math.max(maxCount, sum - minCount);
    }
}
