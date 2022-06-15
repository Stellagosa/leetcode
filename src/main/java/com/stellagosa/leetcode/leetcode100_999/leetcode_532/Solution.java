package com.stellagosa.leetcode.leetcode100_999.leetcode_532;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/16 6:54
 * @Description: 数组中的 k-diff 数对
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 1, 5, 4};
        System.out.println(solution.findPairs(nums, 0));
    }

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue; // 去重
            if (binarySearch(nums, i + 1, k + nums[i])) {
                count++;
            }
        }
        return count;
    }

    // 二分查找等于 target 的值，存在返回 true,不存在返回false
    private boolean binarySearch(int[] nums, int begin, int target) {
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) return true;
            else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return false;
    }
}
