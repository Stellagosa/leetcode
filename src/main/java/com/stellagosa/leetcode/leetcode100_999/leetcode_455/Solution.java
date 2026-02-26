package com.stellagosa.leetcode.leetcode100_999.leetcode_455;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 分发饼干
 * @date 2026/2/26 12:03 星期四
 */
public class Solution {

    public int findContentChildren(int[] g, int [] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, count = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }


}
