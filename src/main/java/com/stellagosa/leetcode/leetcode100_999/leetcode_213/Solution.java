package com.stellagosa.leetcode.leetcode100_999.leetcode_213;

/**
 * @author Stellagosa
 * @description 打家劫舍Ⅱ
 * @date 2023/9/17 9:27 星期日
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 2, 3, 4, 3, 5, 2, 3};
        System.out.println(solution.rob(nums));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        return Math.max(rob(nums, 1, n - 1), rob(nums, 0, n - 2));
    }

    private int rob(int[] nums, int begin, int end) {
        if (begin > end) return nums[0];
        if (begin == end) return nums[begin];
        if (begin == end - 1) return Math.max(nums[begin], nums[end]);
        int dp0 = nums[begin];
        int dp1 = Math.max(nums[begin], nums[begin + 1]);

        for (int i = begin + 2; i <= end; i++) {
            int temp = Math.max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = temp;
        }
        return dp1;
    }

}
