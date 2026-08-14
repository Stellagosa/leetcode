package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3090;

/**
 * @author Stellagosa
 * @description 3090. 每个字符最多出现两次的最长子字符串
 * @date 8/14/2026 6:14 PM Friday
 */
public class Solution {

    public int maximumLengthSubstring(String s) {
        int[] temp = new int[26];
        char[] chars = s.toCharArray();
        int i = 0, j = 0, n = chars.length;
        int max_len = 0;
        while (j < n) {
            int index_j = chars[j] - 'a';
            temp[index_j]++;
            while (temp[index_j] > 2) {
                int index_i = chars[i] - 'a';
                temp[index_i]--;
                i++;
            }
            max_len = Math.max(max_len, j - i + 1);
            j++;
        }
        return max_len;
    }


}
