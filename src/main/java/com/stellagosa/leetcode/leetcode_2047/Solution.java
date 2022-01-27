package com.stellagosa.leetcode.leetcode_2047;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/27 15:24
 * @Description: 句子中的有效单词数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }

    public int countValidWords(String sentence) {
        int mode = 0;
        int count = 0;
        for (int i = 0; i < sentence.length(); i++) {
            switch (check(sentence.charAt(i))) {
                case 1: {
                    switch (mode) {
                        case 0:
                        case 1:
                        case 5:
                        case 10:
                        case 11: {
                            mode = 1;
                            break;
                        }
                        case 2:
                        case 4:
                        case 8:
                        case 9: {
                            mode = 9;
                            break;
                        }
                        case 3:
                        case 6:
                        case 7: {
                            mode = 7;
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    mode = 9;
                    break;
                }
                case 3: {
                    if (mode == 1) mode = 6;
                    else mode = 9;
                    break;
                }
                case 4: {
                    switch (mode) {
                        case 2:
                        case 3:
                        case 4:
                        case 6:
                        case 8:
                        case 9: {
                            mode = 9;
                            break;
                        }
                        case 1:
                        case 7: {
                            mode = 4;
                            break;
                        }
                        case 0:
                        case 5:
                        case 10:
                        case 11: {
                            mode = 8;
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    switch (mode) {
                        case 1:
                        case 4:
                        case 7:
                        case 8: {
                            mode = 11;
                            break;
                        }
                        default: {
                            mode = 10;
                            break;
                        }
                    }
                    break;
                }
            }
            if (mode == 11) count++;
        }
        if (mode == 1 || mode == 4 || mode == 7 || mode == 8) count++;
        return count;
    }

    private int check(char ch) {
        if (ch >= 'a' && ch <= 'z') return 1;
        if (ch >= '0' && ch <= '9') return 2;
        if (ch == '-') return 3;
        if (ch == '!' || ch == '.' || ch == ',') return 4;
        return 5;
    }

}

// 状态
// 0 开始状态
// 1 读入字母
// 2 读入数字
// 3 读入连字符
// 4 符合单词又读入标点
// 5 读入空格
// 6 已有连字符，即最后一个是连字符
// 7 已有连字符且两头有字母
// 8 空格读入标点
// 9 不是单词
// 10 不是单词，从新开始
// 11 是单词，从新开始
//
//          1    2    3    4   5
// 状态\读入 字母 数字 连字符 标点 空格     结束时要不要+1
//  0       1    9    9    8   10       0
//  1       1    9    6    4   11       +1
//  2       9    9    9    9   10       0
//  3       7    9    9    9   10       0
//  4       9    9    9    9   11       +1
//  5       1    9    9    8   10       0
//  6       7    9    9    9   10       0
//  7       7    9    9    4   11       +1
//  8       9    9    9    9   11       +1
//  9       9    9    9    9   10       0
//  10      1    9    9    8   10       0
//  11      1    9    9    8   10       0
