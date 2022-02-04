package com.stellagosa.leetcode.leetcode100_999.leetcode_747;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/13 10:36
 * @Description: 至少是其他数字两倍的最大数
 */
public class Solution {
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;
        int firstBig = Integer.MIN_VALUE;
        int secondBig = Integer.MIN_VALUE;
        int bigNumIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstBig) {
                secondBig = firstBig;
                firstBig = nums[i];
                bigNumIndex = i;
            } else if (nums[i] > secondBig) {
                secondBig = nums[i];
            }
        }
        return firstBig >= secondBig * 2 ? bigNumIndex : -1;
    }
}
