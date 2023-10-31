package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2562;

/**
 * @author Stellagosa
 * @description 找出数组的串联值
 * @date 2023/10/31 19:58 星期二
 */
public class Solution {

    public long findTheArrayConcVal(int[] nums) {
        long result = 0L;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (left == right) {
                result += nums[left];
                break;
            }
            int num1 = nums[left];
            int num2 = nums[right];
            result += num2;
            int temp = 1;
            while (num2 > 0) {
                temp *= 10;
                num2 /= 10;
            }
            result += (long) temp * num1;
            left++;
            right--;
        }
        return result;
    }

}
