package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2047;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/28 0:10
 * @Description: 再改进
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }

    public int countValidWords(String sentence) {
        int mode = 0, count = 0;
        char[] array = sentence.toCharArray();
        for (char ch : array) {
            if (ch >= 'a' && ch <= 'z') {
                if (mode == 0 || mode == 1) {
                    mode = 1;
                } else if (mode == 2 || mode == 3) {
                    mode = 3;
                } else {
                    mode = 5;
                }
            } else if (ch >= '0' && ch <= '9') {
                mode = 5;
            } else if (ch == '-') {
                if (mode == 1) mode = 2;
                else mode = 5;
            } else if (ch == '.' || ch == ',' || ch == '!') {
                if (mode == 0 || mode == 1 || mode == 3) mode = 4;
                else mode = 5;
            } else {
                if (mode == 1 || mode == 3 || mode == 4) count++;
                mode = 0;
            }
        }
        if (mode == 1 || mode == 3 || mode == 4) count++;
        return count;
    }

    // public int countValidWords(String sentence) {
    //     int mode = 0, count = 0;
    //     for (int i = 0; i < sentence.length(); i++) {
    //         char ch = sentence.charAt(i);
    //         if (ch >= 'a' && ch <= 'z') {
    //             if (mode == 0 || mode == 1) {
    //                 mode = 1;
    //             } else if (mode == 2 || mode == 3) {
    //                 mode = 3;
    //             } else {
    //                 mode = 5;
    //             }
    //         } else if (ch >= '0' && ch <= '9') {
    //             mode = 5;
    //         } else if (ch == '-') {
    //             if (mode == 1) mode = 2;
    //             else mode = 5;
    //         } else if (ch == '.' || ch == ',' || ch == '!') {
    //             if (mode == 0 || mode == 1 || mode == 3) mode = 4;
    //             else mode = 5;
    //         } else {
    //             if (mode == 1 || mode == 3 || mode == 4) count++;
    //             mode = 0;
    //         }
    //     }
    //     if (mode == 1 || mode == 3 || mode == 4) count++;
    //     return count;
    // }
}

// 状态
// 0 空格
// 1 字母
// 2 字母+连字符
// 3 字母+连字符+字母
// 4 结尾
// 5 不是单词
//
// 状态\读入 字母 数字 连字符 标点 空格  结束时要不要+1
//  0       1    5    5    4   0       0
//  1       1    5    2    4   0 +1   +1
//  2       3    5    5    5   0       0
//  3       3    5    5    4   0 +1   +1
//  4       5    5    5    5   0 +1   +1
//  5       5    5    5    5   0       0
