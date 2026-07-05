package com.stellagosa.leetcode.leetcode1_99.leetcode_5;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 最长回文字串
 * @date 2021/12/8 21:19
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = solution.longestPalindrome("cbbd");
        System.out.println(s);
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        // 表示[i,j]是不是回文字符串
        boolean[][] flags = new boolean[n][n];

        // 长度为1的字符串肯定是回文字符串
        for (int i = 0; i < n; i++) {
            flags[i][i] = true;
        }

        // 用来存放最长的回文字符串
        // 先初始化成第一个回文字符串
        int start = 0, max_len = 1;

        char[] chars = s.toCharArray();

        // len 表示字符串长度
        for (int len = 2; len <= n; len++) {
            // i表示字符串的起始位置
            for (int i = 0; i < n; i++) {
                // 计算字符串结尾的位置
                // [i,j] 左右闭区间
                int j = i + len - 1;

                // 结尾已经越界，后续可以不用考虑，结束此次循环
                if (j >= n) break;

                if (chars[i] != chars[j]) {
                    flags[i][j] = false;
                } else {
                    if (len <= 3) {
                        flags[i][j] = true;
                    } else {
                        flags[i][j] = flags[i + 1][j - 1];
                    }
                }
                if (flags[i][j] && len > max_len) {
                    max_len = len;
                    start = i;
                }
            }
        }
        return s.substring(start, start + max_len);
    }


    // public String longestPalindrome(String s) {
    //
    //     int max = 0;
    //     int start = 0;
    //     int end = 0;
    //
    //     char[] chars = s.toCharArray();
    //
    //     for (int i = 0; i < chars.length; i++) {
    //         for (int j = i + 1; j < chars.length; j++) {
    //             boolean check = check(chars, i, j);
    //             if (check) {
    //                 if ((j - i + 1) > max) {
    //                     start = i;
    //                     end = j;
    //                     max = j - i + 1;
    //                 }
    //             }
    //         }
    //     }
    //     StringBuilder builder = new StringBuilder();
    //     for (int i = start; i <= end; i++) {
    //         builder.append(chars[i]);
    //     }
    //     return builder.toString();
    // }
    //
    // private boolean check(char[] chars, int start, int end) {
    //     int i = start;
    //     int j = end;
    //
    //     while (i < j) {
    //         if (chars[i] != chars[j]) {
    //             return false;
    //         } else {
    //             i++;
    //             j--;
    //         }
    //     }
    //     return true;
    // }
}
