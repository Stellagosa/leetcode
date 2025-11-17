package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1437;

/**
 * @author Stellagosa
 * @description 是否所有1都至少相隔k个元素
 * @date 2025/11/17 15:56 星期一
 */
public class Solution {

    public boolean kLengthApart(int[] nums, int k) {
        if (k == 0) return true;
        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (pre == -1) {
                    pre = i;
                } else {
                    if (i - pre <= k) return false;
                    pre = i;
                }
            }
        }
        return true;
    }
}
