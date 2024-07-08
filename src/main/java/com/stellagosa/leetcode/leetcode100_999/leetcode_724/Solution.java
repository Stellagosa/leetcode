package com.stellagosa.leetcode.leetcode100_999.leetcode_724;

/**
 * @author Stellagosa
 * @description 寻找数组的中心下标
 * @date 2024/7/8 20:06 星期一
 */
public class Solution {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            int subSum = sum - nums[i];
            if (preSum == subSum) {
                return i;
            } else {
                sum -= nums[i];
                preSum += nums[i];
            }
        }
        return -1;
    }

}
