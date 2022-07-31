package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1374;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/1 7:37
 * @Description: 生成每种字符都是奇数个的字符串
 */
public class Solution {

    public String generateTheString(int n) {
        if ((n & 1) == 1) {
            return "a".repeat(n);
        }
        return "a".repeat(n - 1) + "b";
    }

}
