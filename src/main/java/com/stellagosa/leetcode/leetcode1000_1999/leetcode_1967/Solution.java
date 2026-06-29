package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1967;

/**
 * @author Stellagosa
 * @description 作为子字符串出现在单词中的字符串数目
 * @date 6/29/2026 9:25 AM Monday
 */
public class Solution {

    public int numOfStrings(String[] patterns, String word) {
        char[] chars = word.toCharArray();
        int count = 0;
        for (String s : patterns) {
            char[] pattern = s.toCharArray();
            for (int j = 0; j + pattern.length <= chars.length; j++) {
                boolean flag = false;
                for (int k = 0; k < pattern.length; k++) {
                    if (pattern[k] != chars[j + k]) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

}
