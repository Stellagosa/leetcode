package com.stellagosa.leetcode.leetcode100_999.leetcode_540;

/**
 * @Author: Stellagosa
 * @Date: 2022/2/14 18:04
 * @Description: 有序数组中的单一元素
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3};
        System.out.println(solution.singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {
        return demo(nums, 0, nums.length - 1);
    }

    // 有序数组，一个数出现两次，下标肯定相邻
    // 不考虑出现一次的数，则出现两次的这个数，第一次出现下标是偶数，第二次是奇数
    // 考虑一个出现两次的数，如果第一次出现下标为奇数，则只出现一次的那个数肯定在这个数的左侧
    private int demo(int[] nums, int first, int end) {
        if (first == end) return nums[first];
        int length = end - first + 1;
        int mid = first + length / 2;
        if (nums[mid] == nums[mid - 1]) {
            if (mid % 2 == 0) {
                return demo(nums, first, mid - 2);
            } else {
                return demo(nums, mid + 1, end);
            }
        } else if (nums[mid] == nums[mid + 1]) {
            if (mid % 2 == 0) {
                return demo(nums, mid + 2, end);
            } else {
                return demo(nums, first, mid - 1);
            }
        } else {
            return nums[mid];
        }
    }
}
