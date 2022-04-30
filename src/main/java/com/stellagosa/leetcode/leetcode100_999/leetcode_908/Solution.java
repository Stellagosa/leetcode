package com.stellagosa.leetcode.leetcode100_999.leetcode_908;

/**
 * @Author: Stellagosa
 * @Date: 2022/4/30 10:30
 * @Description: 最小差值Ⅰ
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 10};
        System.out.println(solution.smallestRangeI(nums, 2));
    }

    public int smallestRangeI(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min > 2 * k ? max - min - 2 * k : 0;
    }
}
