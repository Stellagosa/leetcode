package com.stellagosa.leetcode.leetcode100_999.leetcode_719;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/15 18:22
 * @Description: 找出第k小的数对距离
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {38, 33, 57, 65, 13, 2, 86, 75, 4, 56};
        System.out.println(solution.smallestDistancePair(nums, 26));
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int low = 0;
        int high = nums[len - 1] - nums[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (lessTargetCount(nums, mid) >= k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private int lessTargetCount(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            count += binarySearch(nums, i, target + nums[i]) - i;
        }
        return count;
    }

    // 寻找小于等于 target 的最大下标
    private int binarySearch(int[] nums, int begin, int target) {
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return end;
    }
}
