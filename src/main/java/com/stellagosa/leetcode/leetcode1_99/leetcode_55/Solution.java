package com.stellagosa.leetcode.leetcode1_99.leetcode_55;

/**
 * @author Stellagosa
 * @description 跳跃游戏
 * @date 2026/3/1 18:13 星期日
 */
public class Solution {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxPos = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0 && maxPos == i) {
                break;
            }
            maxPos = Math.max(maxPos, nums[i] + i);
        }
        return maxPos >= n - 1;
    }

    // 超时
    // public boolean canJump(int[] nums) {
    //     return dfs(nums, 0);
    // }
    //
    // private boolean dfs(int[] nums, int curIndex) {
    //     int n = nums.length;
    //     if (curIndex >= n - 1) return true;
    //     boolean flag = false;
    //     for (int i = 1; i < nums[curIndex]; i++) {
    //         flag |= dfs(nums, curIndex + i);
    //     }
    //     return flag;
    // }
}
