package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3307;

/**
 * @author Stellagosa
 * @description 找出第k个字符Ⅱ
 * @date 2025/7/4 11:01 星期五
 */
public class Solution {

    public char kthCharacter(long k, int[] operations) {
        if (k == 1) return 'a';
        long n = ln(k);
        char res = kthCharacter(k - (1L << (n - 1)), operations);
        if (operations[(int) (n - 1)] == 1) {
            if (res == 'z') return 'a';
            return (char) (res + 1);
        } else {
            return res;
        }
    }


    // 2^n >= num,计算最小n
    private long ln(long num) {
        int n = 0;
        while ((1L << n) < num) {
            n++;
        }
        return n;
    }

}
