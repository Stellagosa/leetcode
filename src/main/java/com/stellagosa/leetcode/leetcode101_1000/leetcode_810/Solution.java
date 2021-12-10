package com.stellagosa.leetcode.leetcode101_1000.leetcode_810;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 22:00
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{0, 1};
        boolean game = solution.xorGame(nums);
        System.out.println(game);
    }

    public boolean xorGame(int[] nums) {
        int n = nums.length;
        if ((n & 1) == 0) return true;
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        return sum == 0;
    }
}
