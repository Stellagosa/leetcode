package com.stellagosa.leetcode.leetcode1_99.leetcode_34;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/16 7:27
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] res = solution.searchRange(nums, 8);
        System.out.println(Arrays.toString(res));
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearchFirstIndex(nums, target), binarySearchLastIndex(nums, target)};
    }

    // 查找目标值最左边的位置
    private int binarySearchFirstIndex(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] >= target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        if (begin >= nums.length || nums[begin] != target) return -1;
        return begin;
    }

    // 查找目标值最右边的位置
    private int binarySearchLastIndex(int[] nums, int target) {
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        if (end < 0 || nums[end] != target) return -1;
        return end;
    }
}
