package com.stellagosa.leetcode.leetcode100_999.leetcode_344;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/7 8:07
 * @Description: 反转字符串
 */
public class Solution {

    public void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < len / 2; ++i) {
            char temp = s[i];
            s[i] = s[len - i - 1];
            s[len - i - 1] = temp;
        }
    }
}
