package com.stellagosa.leetcode.leetcode100_999.leetcode_136;

/**
 * @author Stellagosa
 * @description 只出现一次的数字
 * @date 2023/10/14 17:00 星期六
 */
public class Solution {

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

}
