package com.stellagosa.leetcode.leetcode101_1000.leetcode_264;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 21:50
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = solution.nthUglyNumber(3);
        System.out.println(number);
    }

    public int nthUglyNumber(int n) {
        int[] nums = new int[n + 1];
        nums[1] = 1;
        int a = 1, b = 1, c = 1;
        for (int i = 2; i <= n; i++) {
            int x = nums[a] * 2;
            int y = nums[b] * 3;
            int z = nums[c] * 5;
            nums[i] = min(x, y, z);
            if (nums[i] == x) a++;
            if (nums[i] == y) b++;
            if (nums[i] == z) c++;
        }
        return nums[n];
    }

    public int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }
}
