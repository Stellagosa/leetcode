package com.stellagosa.leetcode.leetcode100_999.leetcode_153;

/**
 * @author Stellagosa
 * @description 寻找旋转排序数组中的最小值
 * @date 5/16/2026 10:25 AM Saturday
 */
public class Solution {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }


//    public int findMin(int[] nums) {
//        return help(nums, 0, nums.length - 1);
//    }
//
//    public int help(int[] nums, int left, int right) {
//        int mid = (left + right) / 2;
//        if (left == right) return nums[left];
//        else if (nums[mid] > nums[right]) {
//            left = mid + 1;
//        } else {
//            right = mid;
//        }
//        return help(nums, left, right);
//    }
}
