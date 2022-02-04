package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1576;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/5 10:16
 * @Description: 替换所有的问号
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // for (char i = 'a'; i <= 'z'; i++) {
        //     System.out.println(i);
        // }

        System.out.println(solution.modifyString("a?bzs"));
    }


    public String modifyString(String s) {
        if (s.length() == 1) {
            if (s.charAt(0) == '?') return "a";
            return s;
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                if (i == 0) {
                    builder.append(getDifferent(' ', s.charAt(1)));
                } else if (i == s.length() - 1) {
                    builder.append(getDifferent(builder.charAt(i - 1), ' '));
                } else {
                    builder.append(getDifferent(builder.charAt(i - 1), s.charAt(i + 1)));
                }
            } else {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }

    private char getDifferent(char c1, char c2) {
        for (char i = 'a'; i <= 'z'; i++) {
            if (i != c1 && i != c2) return i;
        }
        return ' ';
    }
}
