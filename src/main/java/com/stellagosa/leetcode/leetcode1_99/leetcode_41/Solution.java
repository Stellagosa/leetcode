package com.stellagosa.leetcode.leetcode1_99.leetcode_41;

/**
 * @author Stellagosa
 * @description 缺失的第一个正数
 * @date 2026/2/25 12:21 星期三
 */
public class Solution {

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] > 0 && nums[i] < n + 1) {
                if (nums[i] == i + 1) {
                    i++;
                } else {
                    if (nums[i] == nums[nums[i] - 1]) {
                        i++;
                    } else {
                        swap(nums, i, nums[i] - 1);
                    }
                }
            } else {
                i++;
            }
        }

        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) return j + 1;
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
