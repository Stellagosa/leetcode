package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2609;

/**
 * @author Stellagosa
 * @description 最长平衡子字符串
 * @date 2023/11/8 8:20 星期三
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheLongestBalancedSubstring("01000111"));
    }

    public int findTheLongestBalancedSubstring(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int count_0 = 0, count_1 = 0;
        boolean flag = false;
        int max = 0;
        for (char aChar : chars) {
            if (!flag) {
                if (aChar == '0') {
                    count_0++;
                } else {
                    count_1++;
                    flag = true;
                }
            } else {
                if (aChar == '0') {
                    max = Math.max(max, Math.min(count_0, count_1));
                    count_0 = 1;
                    count_1 = 0;
                    flag = false;
                } else {
                    count_1++;
                }
            }
        }
        max = Math.max(max, Math.min(count_0, count_1));
        return max << 1;
    }

}
