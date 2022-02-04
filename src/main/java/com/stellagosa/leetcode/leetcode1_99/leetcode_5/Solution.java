package com.stellagosa.leetcode.leetcode1_99.leetcode_5;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:19
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.longestPalindrome("babad");
        System.out.println(s);
    }

    public String longestPalindrome(String s) {

        int max = 0;
        int start = 0;
        int end = 0;

        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                boolean check = check(chars, i, j);
                if (check) {
                    if ((j - i + 1) > max) {
                        start = i;
                        end = j;
                        max = j - i + 1;
                    }
                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = start; i <= end; i++) {
            builder.append(chars[i]);
        }
        return builder.toString();
    }

    private boolean check(char[] chars, int start, int end) {
        int i = start;
        int j = end;

        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
