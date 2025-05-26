package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2131;

/**
 * @author Stellagosa
 * @description 连接两字母单词得到的最长回文串
 * @date 2025/5/26 17:36 星期一
 */
public class Solution {

    // 二维数组，只需遍历斜三角的位置
    public int longestPalindrome(String[] words) {
        int[][] count = new int[26][26];

        for (String word : words) {
            char[] chars = word.toCharArray();
            count[chars[0] - 'a'][chars[1] - 'a']++;
        }

        boolean flag = false;
        int res = 0;

        for (int i = 0; i < count.length; i++) {
            if (flag) {
                res += count[i][i] / 2 * 4;
            } else {
                if (count[i][i] % 2 == 1) {
                    flag = true;
                }
                res += count[i][i] * 2;
            }
            for (int j = i + 1; j < count[i].length; j++) {
                if (count[i][j] == 0) continue;
                res += Math.min(count[i][j], count[j][i]) * 4;
            }
        }


        // for (int i = 0; i < count.length; i++) {
        //     for (int j = i; j < count[i].length; j++) {
        //         if (count[i][j] == 0) continue;
        //         if (i != j) {
        //             res += Math.min(count[i][j], count[j][i]) * 4;
        //         } else {
        //             if (flag) {
        //                 res += (count[i][j] / 2) * 4;
        //             } else {
        //                 if (count[i][j] % 2 == 1) {
        //                     flag = true;
        //                 }
        //                 res += count[i][j] * 2;
        //             }
        //         }
        //     }
        // }
        return res;
    }


    // 一维数组重复遍历
    // public int longestPalindrome(String[] words) {
    //     int[] count = new int[26 * 26];
    //
    //     for (String word : words) {
    //         char[] chars = word.toCharArray();
    //         int c = (chars[0] - 'a') * 26 + (chars[1] - 'a');
    //         count[c]++;
    //     }
    //
    //     boolean flag = false;
    //     int res = 0;
    //
    //     for (int i = 0; i < count.length; i++) {
    //         if (count[i] == 0) continue;
    //         int ch1 = i / 26;
    //         int ch2 = i % 26;
    //
    //         if (ch1 != ch2) {
    //             res += Math.min(count[i], count[ch2 * 26 + ch1]) * 2;
    //         } else {
    //             if (flag) {
    //                 res += (count[i] / 2) * 4;
    //             } else {
    //                 if (count[i] % 2 == 1) {
    //                     flag = true;
    //                 }
    //                 res += count[i] * 2;
    //             }
    //         }
    //     }
    //     return res;
    // }

}
