package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1732;

/**
 * @author Stellagosa
 * @description 找到最高海拔
 * @date 6/19/2026 9:10 AM June
 */
public class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0, sum = 0;
        for (int num : gain) {
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }
}
