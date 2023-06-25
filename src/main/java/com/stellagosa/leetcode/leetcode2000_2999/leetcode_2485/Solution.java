package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2485;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/26 7:44
 * @Description: 找出中枢整数
 */
public class Solution {
    public int pivotInteger(int n) {
        int x = (int) Math.sqrt((n * (n + 1)) >> 1);
        if (x * x * 2 == n * (n + 1)) {
            return x;
        }
        return -1;
    }
}
