package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2582;

/**
 * @author Stellagosa
 * @description 递枕头
 * @date 2023/9/26 7:17 星期二
 */
public class Solution {

    public int passThePillow(int n, int time) {
        int div = time / (n - 1);
        int mod = time % (n - 1);
        // return div % 2 == 0 ? mod + 1 : n - mod;
        return (div & 1) != 1 ? mod + 1 : n - mod;
    }
}
