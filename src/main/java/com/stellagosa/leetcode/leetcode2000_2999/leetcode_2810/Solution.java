package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2810;

/**
 * @author Stellagosa
 * @description 故障键盘
 * @date 2024/4/1 7:59 星期一
 */
public class Solution {

    public String finalString(String s) {
        if (s.indexOf('i') < 0) return s;
        StringBuilder builder = new StringBuilder();
        char[] charArray = s.toCharArray();

        for (char ch : charArray) {
            if (ch == 'i') {
                builder.reverse();
            } else {
                builder.append(ch);
            }
        }
        return builder.toString();
    }
}
