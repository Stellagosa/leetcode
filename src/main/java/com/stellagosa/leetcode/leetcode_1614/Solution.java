package com.stellagosa.leetcode.leetcode_1614;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/7 22:36
 * @Description: 括号的最大嵌套深度
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDepth("(1+(2*3)+((8)/4))+1"));
    }

    public int maxDepth(String s) {
        char[] array = s.toCharArray();
        int depth = 0;
        int max = 0;
        for (char ch : array) {
            if (ch == '(') {
                depth++;
                max = Math.max(depth, max);
            }
            if (ch == ')') {
                depth--;
            }
        }
        return max;
    }
}
