package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3011;

/**
 * @author Stellagosa
 * @description 判断一个数组是否可以变为有序
 * @date 2024/7/13 5:36 星期六
 */
public class Solution {

    public boolean canSortArray(int[] nums) {
        int preMin = nums[0];
        int preMax = nums[0];
        int preCount = Integer.bitCount(nums[0]);
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (Integer.bitCount(nums[i]) == preCount) {
                preMin = Math.min(preMin, nums[i]);
                preMax = Math.max(preMax, nums[i]);
            } else {
                break;
            }
            i++;
        }
        while (i < n) {
            int nextMin = nums[i];
            int nextMax = nums[i];
            int nextCount = Integer.bitCount(nums[i]);
            while (i < n) {
                if (Integer.bitCount(nums[i]) == nextCount) {
                    nextMin = Math.min(nextMin, nums[i]);
                    nextMax = Math.max(nextMax, nums[i]);
                } else {
                    break;
                }
                i++;
            }
            if (nextMin > preMax) {
                preMin = nextMin;
                preMax = nextMax;
                preCount = nextCount;
            } else {
                return false;
            }
        }
        return true;
    }

}
