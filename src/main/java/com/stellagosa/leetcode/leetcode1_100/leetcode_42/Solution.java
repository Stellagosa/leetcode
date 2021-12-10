package com.stellagosa.leetcode.leetcode1_100.leetcode_42;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:37
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int res = solution.trap(height);
        System.out.println(res);
    }

    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        int left_max = 0;
        int right_max = 0;
        while (left < right) {
            if (height[left] <= height[right]) {
                left_max = Math.max(left_max, height[left]);
                res += left_max - height[left];
                left++;
            } else {
                right_max = Math.max(right_max, height[right]);
                res += right_max - height[right];
                right--;
            }
        }
        return res;
    }
}
