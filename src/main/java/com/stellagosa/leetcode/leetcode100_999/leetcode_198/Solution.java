package com.stellagosa.leetcode.leetcode100_999.leetcode_198;

/**
 * @author Stellagosa
 * @description 打家劫舍
 * @date 2023/9/16 10:14 星期六
 */
public class Solution {

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int dp0 = nums[0];
        int dp1 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int temp = Math.max(dp0 + nums[i], dp1);
            dp0 = dp1;
            dp1 = temp;
        }
        return dp1;
    }

}
