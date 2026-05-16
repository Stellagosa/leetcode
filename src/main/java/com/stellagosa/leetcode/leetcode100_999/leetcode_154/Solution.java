package com.stellagosa.leetcode.leetcode100_999.leetcode_154;

/**
 * @author Stellagosa
 * @description 寻找旋转排序数组中的最小值Ⅱ
 * @date 5/16/2026 1:59 PM Saturday
 */
public class Solution {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            while (nums[mid] == nums[right] && mid < right) {
                right--;
            }
            if (mid == right) continue;
            else if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
