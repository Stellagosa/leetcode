package com.stellagosa.leetcode.leetcode100_999.leetcode_268;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/10 下午 03:13
 * @Description: 丢失的数字
 */
public class Solution {

    // x^x=x    x^0=0
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int count = n;
        for (int i = 0; i < n; i++) {
            count ^= nums[i];
            count ^= i;
        }
        return count;
    }


    // [1,n]求和减一遍
    // public int missingNumber(int[] nums) {
    //     int n = nums.length;
    //     int total = n * (n + 1) / 2;
    //     for (int num : nums) {
    //         total -= num;
    //     }
    //     return total;
    // }

}
