package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2481;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/17 20:21
 * @Description: 分割圆的最少切割次数
 */
public class Solution {

    public int numberOfCuts(int n) {
        if (n == 1) return 0;
        else if (n % 2 == 0) return n >> 1;
        return n;
    }

}
