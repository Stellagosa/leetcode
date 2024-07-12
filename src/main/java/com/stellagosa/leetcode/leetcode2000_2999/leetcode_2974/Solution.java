package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2974;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 最小数字游戏
 * @date 2024/7/12 8:32 星期五
 */
public class Solution {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = temp;
        }
        return nums;
    }

}
