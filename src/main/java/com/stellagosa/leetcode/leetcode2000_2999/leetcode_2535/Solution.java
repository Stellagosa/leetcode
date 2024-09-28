package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2535;

/**
 * @author Stellagosa
 * @description 数组元素和与数字和的绝对差
 * @date 2024/9/26 9:02 星期四
 */
public class Solution {

    public int differenceOfSum(int[] nums) {
        return Math.abs(sumOfArrays(nums) - sumOfEveryDigit(nums));
    }

    private int sumOfArrays(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    private int sumOfEveryDigit(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
        }
        return sum;
    }

}
