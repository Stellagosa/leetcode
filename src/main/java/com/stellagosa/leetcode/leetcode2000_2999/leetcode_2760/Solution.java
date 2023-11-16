package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2760;

/**
 * @author Stellagosa
 * @description 最长奇偶子数组
 * @date 2023/11/16 10:12 星期四
 */
public class Solution {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        boolean flag = false, begin = false;
        int max = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (!begin) {
                if (nums[i] % 2 == 0 && nums[i] <= threshold) {
                    begin = true;
                    flag = true;
                    pre = i;
                }
            } else {
                if (flag && nums[i] % 2 == 1 && nums[i] <= threshold) {
                    flag = false;
                } else if (!flag && nums[i] % 2 == 0 && nums[i] <= threshold) {
                    flag = true;
                } else {
                    max = Math.max(max, i - pre);
                    flag = false;
                    begin = false;
                    i--;
                }
            }
        }
        if (begin) {
            max = Math.max(max, nums.length - pre);
        }
        return max;
    }

}
