package com.stellagosa.leetcode.leetcode100_999.leetcode_522;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/27 5:15
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"aaa", "aaa", "aa"};
        System.out.println(solution.findLUSlength(strs));
    }

    public int findLUSlength(String[] strs) {
        // 按字符串长度排序，长的在前
        Arrays.sort(strs, ((o1, o2) -> o2.length() - o1.length()));

        for (int i = 0; i < strs.length; i++) {
            int j = 0;
            boolean flag = true;
            while (j < strs.length && strs[j].length() >= strs[i].length()) {
                if (i == j) {
                    j++;
                    continue;
                }
                if (strs[j].length() == strs[i].length()) {
                    if (strs[i].equals(strs[j])) {
                        flag = false;
                        break;
                    }
                } else {
                    if (isSonSeries(strs[j], strs[i])) {
                        flag = false;
                        break;
                    }
                }
                j++;
            }
            if (flag) return strs[i].length();
        }
        return -1;
    }

    private boolean isSonSeries(String longStr, String shortStr) {
        int p = 0, q = 0;
        while (p < longStr.length() && q < shortStr.length()) {
            if (longStr.charAt(p) == shortStr.charAt(q)) {
                p++;
                q++;
            } else {
                p++;
            }
        }
        return q == shortStr.length();
    }
}
