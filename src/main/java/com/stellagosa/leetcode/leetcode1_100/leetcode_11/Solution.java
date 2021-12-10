package com.stellagosa.leetcode.leetcode1_100.leetcode_11;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:21
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] test = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = solution.maxArea(test);
        System.out.println(maxArea);
    }

    public int maxArea(int[] height) {

        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            if (height[start] < height[end]) {
                int area = height[start] * (end - start);
                maxArea = Math.max(maxArea, area);
                start++;
            } else {
                int area = height[end] * (end - start);
                maxArea = Math.max(maxArea, area);
                end--;
            }
        }
        return maxArea;
    }
}
