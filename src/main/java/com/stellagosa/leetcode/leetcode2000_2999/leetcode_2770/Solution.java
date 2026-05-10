package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2770;

/**
 * @author Stellagosa
 * @description 达到末尾下标所需的最大跳跃次数
 * @date 2026/5/10 9:59 星期日
 */
public class Solution {

    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 1; i < n; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                int temp = nums[i] - nums[j];
                if (temp >= -target && temp <= target) {
                    max = Math.max(max, res[j]);
                }
            }
            if (max == -1) {
                res[i] = -1;
            } else {
                res[i] = max + 1;
            }
        }
        return res[n-1];
    }

}
