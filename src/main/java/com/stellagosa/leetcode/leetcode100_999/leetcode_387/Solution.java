package com.stellagosa.leetcode.leetcode100_999.leetcode_387;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/13 8:39
 * @Description: 字符串中的第一个唯一字符
 */
public class Solution {

    public int firstUniqChar(String s) {
        int minLoc = -1;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int loc = s.indexOf(ch);
            if (loc != -1 && s.lastIndexOf(ch) == loc) {
                minLoc = minLoc == -1 ? loc : Math.min(minLoc, loc);
            }
        }
        return minLoc;
    }

    // public int firstUniqChar(String s) {
    //     int[] charCount = new int[26];
    //
    //     for (char ch : s.toCharArray()) {
    //         charCount[ch - 'a']++;
    //     }
    //
    //     for (int i = 0; i < s.length(); i++) {
    //         if (charCount[s.charAt(i) - 'a'] == 1) return i;
    //     }
    //     return -1;
    // }

}
