package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1422;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/14 7:37
 * @Description: 分割字符串的最大得分
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxScore("00"));
    }

    public int maxScore(String s) {
        int len = s.length();
        int zeroCount = 0;
        for (char ch : s.toCharArray()) {
            zeroCount += ch == '0' ? 1 : 0;
        }

        int leftZeroCount = 0;
        int maxScore = 0;
        for (int i = 0; i < len - 1; i++) {
            leftZeroCount += s.charAt(i) == '0' ? 1 : 0;
            maxScore = Math.max(maxScore, leftZeroCount + (len - zeroCount) - (i + 1 - leftZeroCount));
        }

        return maxScore;
    }
}
