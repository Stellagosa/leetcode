package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1784;

/**
 * @author Stellagosa
 * @description 检查二进制字符串字段
 * @date 2026/3/6 14:34 星期五
 */
public class Solution {

    public boolean checkOnesSegment(String s) {
        boolean flag1 = false;
        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                flag1 = true;
            } else {
                if (flag1) return false;
            }
        }
        return true;
    }

}
