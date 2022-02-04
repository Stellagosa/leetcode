package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1332;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/22 12:16
 * @Description: 删除回文子序列
 */
public class Solution {

    // 子序列可以不连续
    public int removePalindromeSub(String s) {
        if (s.length() == 0) return 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - i - 1)) return 2;
        }
        return 1;
    }
}
