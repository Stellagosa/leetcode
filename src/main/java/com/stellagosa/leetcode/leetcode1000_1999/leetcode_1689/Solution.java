package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1689;

/**
 * @author Stellagosa
 * @description 十-二进制数的最少数目
 * @date 2026/3/1 17:52 星期日
 */
public class Solution {

    public int minPartitions(String n) {
        int max = -1;
        for (char ch : n.toCharArray()) {
            max = Math.max(max, ch - '0');
        }
        return max;
    }

    // public int minPartitions(String n) {
    //     int max = -1;
    //     for (int i = 0; i < n.length(); i++) {
    //         max = Math.max(max, n.charAt(i) - '0');
    //     }
    //     return max;
    // }
}
