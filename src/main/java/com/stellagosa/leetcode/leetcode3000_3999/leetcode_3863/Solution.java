package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3863;

/**
 * @author Stellagosa
 * @description 3863.将一个字符串排序的最小操作次数
 * @date 10/21/2026 5:39 AM Wednesday
 */
public class Solution {

    public int minOperations(String s) {
        int n = s.length();
        if (n == 1) return 0;
        if (n == 2) {
            if (s.charAt(0) <= s.charAt(1)) return 0;
            return -1;
        }

        char min = 'z', max = 'a';
        int min_count = 0, max_count = 1;
        boolean sorted = true;
        char pre = 'a';
        for (char ch : s.toCharArray()) {
            if (ch < min) {
                min = ch;
                min_count = 1;
            } else if (ch == min) {
                min_count++;
            }
            if (ch > max) {
                max = ch;
                max_count = 1;
            } else if (ch == max) {
                max_count++;
            }
            if (ch < pre) {
                sorted = false;
            }
            pre = ch;
        }

        if (sorted) return 0;
        if (s.charAt(0) == min || s.charAt(n - 1) == max) return 1;
        if (min_count == 1 && max_count == 1 && s.charAt(0) == max && s.charAt(n - 1) == min) return 3;
        return 2;
    }
}
