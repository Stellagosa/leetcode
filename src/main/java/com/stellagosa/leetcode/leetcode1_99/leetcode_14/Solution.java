package com.stellagosa.leetcode.leetcode1_99.leetcode_14;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:25
 */
public class Solution {
    public static void main(String[] args) {
        String[] strings = {"abc", "ab", "abd"};
        Solution solution = new Solution();
        String s = solution.longestCommonPrefix(strings);
        System.out.println(s);
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length <= 0) return "";
        int minLength = strs[0].length();
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < minLength; i++) {
            boolean check = check(strs, i);
            if (!check) break;
            builder.append(strs[0].charAt(i));
        }
        return builder.toString();
    }

    // 判断 strs 中的每个字符串的第 index 个字母是否相等
    private boolean check(String[] strs, int index) {
        char c = strs[0].charAt(index);
        for (int i = 1; i < strs.length; i++) {
            if (c != strs[i].charAt(index)) return false;
        }
        return true;
    }
}
