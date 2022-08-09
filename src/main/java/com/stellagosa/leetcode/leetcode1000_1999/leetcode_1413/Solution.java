package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1413;

/**
 * @Author: Stellagosa
 * @Date: 2022/8/9 10:33
 * @Description: 逐步求和得到正数的最小值
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-3, 2, -3, 4, 2};
        System.out.println(solution.minStartValue(nums));
    }

    public int minStartValue(int[] nums) {
        int startValue = 1, sum = 0;
        for (int num : nums) {
            sum += num;
            startValue = startValue > -sum ? startValue : 1 - sum;
        }
        return startValue;
    }

}
