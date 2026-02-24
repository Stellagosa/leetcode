package com.stellagosa.leetcode.leetcode1_99.leetcode_31;

/**
 * @author Stellagosa
 * @description 下一个排列
 * @date 2026/02/24 21:20 星期二
 */
public class Solution {

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = len - 1;
        while (i > 0) {
            if (nums[i] > nums[i - 1]) break;
            i--;
        }

        // 从i开始的数是从大到小排序的
        // 现在要变成从小到大排序
        // 前后两两交换

        for (int j = i, k = len - 1; j < k; j++, k--) {
            swap(nums, j, k);
        }

        if (i == 0) return;
        for (int j = i; j < len; j++) {
            if (nums[j] > nums[i - 1]) {
                swap(nums,i - 1,j);
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



//    public void nextPermutation(int[] nums) {
//        int len = nums.length;
//        int i = len - 1;
//        while (i > 0) {
//            if (nums[i] > nums[i - 1]) break;
//            i--;
//        }
//        Arrays.sort(nums, i, len);
//        if (i == 0) return;
//        for (int j = i; j < len; j++) {
//            if (nums[j] > nums[i - 1]) {
//                int temp = nums[i - 1];
//                nums[i - 1] = nums[j];
//                nums[j] = temp;
//                break;
//            }
//        }
//    }

}
