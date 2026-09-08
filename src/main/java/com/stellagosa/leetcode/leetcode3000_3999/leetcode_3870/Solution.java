package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3870;

/**
 * @author Stellagosa
 * @description 3870.统计范围内的逗号
 * @date 9/8/2026 8:29 AM Tuesday
 */
public class Solution {

    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }
        if (n < 1000000) {
            return n - 999;
        }
        if (n < 1000000000) {
            return 2 * (n - 999999) + 999000;
        }
        return 3 * (n - 999999999) + 999000000 + 999000;
    }

}
