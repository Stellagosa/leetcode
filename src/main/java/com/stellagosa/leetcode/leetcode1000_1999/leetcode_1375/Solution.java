package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1375;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/14 9:46
 * @Description: 二进制字符串前缀一致的次数
 */
public class Solution {

    public int numTimesAllBlue(int[] flips) {
        // 所有位置只翻转一次，（0->1）

        int n = flips.length;
        int max = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(flips[i], max);
            if (max == i + 1) result++;
        }
        return result;
    }

}
