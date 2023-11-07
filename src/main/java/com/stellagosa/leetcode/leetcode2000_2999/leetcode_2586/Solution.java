package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2586;

/**
 * @author Stellagosa
 * @description 统计范围内的元音字符串数
 * @date 2023/11/7 8:21 星期二
 */
public class Solution {

    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for (int i = left; i <= right; ++i) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                count++;
            }
        }
        return count;
    }

    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
