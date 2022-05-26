package com.stellagosa.leetcode.leetcode100_999.leetcode_242;

/**
 * @Author: Stellagosa
 * @Date: 2022/5/26 11:08
 * @Description: 有效的字母异位词
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(solution.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] counts = new int[26];

        for (char c : s.toCharArray()) {
            counts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            counts[c - 'a']--;
        }

        for (int count : counts) {
            if (count != 0) return false;
        }
        return true;
    }
}
