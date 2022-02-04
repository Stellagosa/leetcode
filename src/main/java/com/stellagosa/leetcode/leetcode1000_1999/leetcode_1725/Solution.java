package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1725;

/**
 * @Author: Stellagosa
 * @Date: 2022/2/4 10:15
 * @Description:
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] rectangles = {{5, 8}, {3, 9}, {5, 12}, {16, 5}};
        System.out.println(solution.countGoodRectangles(rectangles));
    }

    public int countGoodRectangles(int[][] rectangles) {
        int count = 0;
        int maxLen = 0;
        for (int[] item : rectangles) {
            int min = Math.min(item[0], item[1]);
            if (min > maxLen) {
                maxLen = min;
                count = 1;
            } else if (min == maxLen) {
                count++;
            }
        }
        return count;
    }
}
