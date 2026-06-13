package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3838;

/**
 * @author Stellagosa
 * @description 带权单词映射
 * @date 6/13/2026 6:15 PM June
 */
public class Solution {

    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            char[] chars = word.toCharArray();
            int weight = 0;
            for (char ch : chars) {
                weight += weights[ch - 'a'];
            }
            weight = weight % 26;
            sb.append((char) ('z' - weight));
        }
        return sb.toString();
    }

}
