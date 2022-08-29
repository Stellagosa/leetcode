package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1470;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/29 15:57
 * @Description: 重新排列数组
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 2, 4, 6, 1, 3, 5, 7};
        int[] arr = solution.shuffle(nums, 4);
        for (int num : arr) {
            System.out.println(num);
        }
    }

    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[n << 1];
        for (int i = 0; i < n; i++) {
            arr[i << 1] = nums[i];
            arr[1 + (i << 1)] = nums[i + n];
        }
        return arr;
    }

}
