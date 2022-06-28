package com.stellagosa.leetcode.leetcode100_999.leetcode_324;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/28 5:48
 * @Description: 摆动排序 II
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 5, 1, 1, 6, 4};
        // int[] nums = {1, 3, 2, 2, 3, 1};
        // int[] nums = {1, 1, 2, 1, 2, 2, 1};
        // int[] nums = {4, 5, 5, 6};
        solution.wiggleSort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    // 1,1,1,4,5,6
    // 1,4,1,5,1,6

    // 1,1,1,2,4,5,6
    // 1,2,1,4,1,5,0

    // 1,1,1,1,2,2,2
    // 1,2,1,2,1,2,1
    public void wiggleSort(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int n = nums.length;
        int p = (n + 1) / 2 - 1;
        int q = n - 1;
        for (int i = 0; i < n - 1; i += 2) {
            nums[i] = arr[p];
            nums[i + 1] = arr[q];
            p--;
            q--;
        }
        if (n % 2 == 1) {
            nums[n - 1] = arr[0];
        }
    }
}
