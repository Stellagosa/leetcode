package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2529;

/**
 * @author Stellagosa
 * @description 正整数和负整数的最大计数
 * @date 2024/4/12 13:13 星期五
 */
public class Solution {

    public int maximumCount(int[] nums) {
        int search1 = binarySearch1(nums);
        int search2 = binarySearch2(nums);

        int n = nums.length;

        return Math.max(search1 + 1, n - search2);
    }

    /**
     * 二分查找最大负整数的位置
     */
    private int binarySearch1(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    /**
     * 二分查找最小正整数的位置
     */
    private int binarySearch2(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;

        while (l <= r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= 0) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }


    // public int maximumCount(int[] nums) {
    //     int pos = 0, neg = 0;
    //     for (int num : nums) {
    //         if (num > 0) {
    //             pos++;
    //         }
    //         if (num < 0) {
    //             neg++;
    //         }
    //     }
    //     return Math.max(pos, neg);
    // }
}
