package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2047;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/27 18:08
 * @Description: 状态重复，优化
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }

    public int countValidWords(String sentence) {
        int mode = 0;
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                if (mode == 0 || mode == 1 || mode == 7) {
                    mode = 1;
                } else if (mode == 3 || mode == 5 || mode == 6) {
                    mode = 6;
                } else {
                    mode = 4;
                }
            } else if (ch >= '0' && ch <= '9') {
                mode = 6;
            } else if (ch == '-') {
                if (mode == 1) mode = 2;
                else mode = 6;
            } else if (ch == '.' || ch == ',' || ch == '!') {
                if (mode == 0 || mode == 7) mode = 5;
                else if (mode == 1 || mode == 4) mode = 3;
                else mode = 6;
            } else {
                if (mode == 1 || mode == 3 || mode == 4 || mode == 5) mode = 7;
                else mode = 0;
            }
            if (mode == 7) count++;
        }
        if (mode == 1 || mode == 3 || mode == 4 || mode == 5) count++;
        return count;
    }

    // public int countValidWords(String sentence) {
    //     int mode = 0;
    //     int count = 0;
    //     for (int i = 0; i < sentence.length(); i++) {
    //         switch (check(sentence.charAt(i))) {
    //             case 1: {
    //                 switch (mode) {
    //                     case 0:
    //                     case 1:
    //                     case 7: {
    //                         mode = 1;
    //                         break;
    //                     }
    //                     case 3:
    //                     case 5:
    //                     case 6: {
    //                         mode = 6;
    //                         break;
    //                     }
    //                     case 2:
    //                     case 4: {
    //                         mode = 4;
    //                         break;
    //                     }
    //                 }
    //                 break;
    //             }
    //             case 2: {
    //                 mode = 6;
    //                 break;
    //             }
    //             case 3: {
    //                 if (mode == 1) mode = 2;
    //                 else mode = 6;
    //                 break;
    //             }
    //             case 4: {
    //                 switch (mode) {
    //                     case 0:
    //                     case 7: {
    //                         mode = 5;
    //                         break;
    //                     }
    //                     case 1:
    //                     case 4: {
    //                         mode = 3;
    //                         break;
    //                     }
    //                     default: {
    //                         mode = 6;
    //                         break;
    //                     }
    //                 }
    //                 break;
    //             }
    //             case 5: {
    //                 switch (mode) {
    //                     case 1:
    //                     case 3:
    //                     case 4:
    //                     case 5: {
    //                         mode = 7;
    //                         break;
    //                     }
    //                     default: {
    //                         mode = 0;
    //                         break;
    //                     }
    //                 }
    //                 break;
    //             }
    //         }
    //         if (mode == 7) count++;
    //     }
    //     if (mode == 1 || mode == 3 || mode == 4 || mode == 5) count++;
    //     return count;
    // }
    //
    // private int check(char ch) {
    //     if (ch >= 'a' && ch <= 'z') return 1;
    //     if (ch >= '0' && ch <= '9') return 2;
    //     if (ch == '-') return 3;
    //     if (ch == '!' || ch == '.' || ch == ',') return 4;
    //     return 5;
    // }
}

// 状态
// 0 不是单词，重新开始
// 1 读入字母
// 2 读入连字符，即最后一个是连字符
// 3 符合单词又读入标点
// 4 已有连字符且两头有字母
// 5 空格读入标点
// 6 不是单词
// 7 是单词，从新开始
//
//          1    2    3    4   5
// 状态\读入 字母 数字 连字符 标点 空格  结束时要不要+1
//  0       1    6    6    5   0       0
//  1       1    6    2    3   7       +1
//  2       4    6    6    6   0       0
//  3       6    6    6    6   7       +1
//  4       4    6    6    3   7       +1
//  5       6    6    6    6   7       +1
//  6       6    6    6    6   0       0
//  7       1    6    6    5   0       0
