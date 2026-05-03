package com.stellagosa.leetcode.leetcode100_999.leetcode_796;

/**
 * @author Stellagosa
 * @description 旋转字符串
 * @date 2026/5/3 13:56 星期日
 */
public class Solution {

    public boolean rotateString(String s, String goal) {
        char[] source = s.toCharArray();
        char[] target = goal.toCharArray();
        int n = source.length;
        if (target.length != n) return false;
        for (int i = 0; i < n; i++) {
            if (check(source, target, i, n)) return true;
        }
        return false;
    }

    private boolean check(char[] source, char[] target, int begin, int n) {
        for (int i = 0; i < n; i++) {
            if (source[(begin + i) % n] != target[i]) return false;
        }
        return true;
    }
}
