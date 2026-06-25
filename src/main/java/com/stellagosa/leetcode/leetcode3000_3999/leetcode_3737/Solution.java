package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3737;

/**
 * @author Stellagosa
 * @description 统计主要元素子数组数目Ⅰ
 * @date 6/25/2026 9:10 PM June
 */
public class Solution {

    public int countMajoritySubarrays(int[] nums, int target) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) cnt++;
                else cnt--;
                if (cnt > 0) res++;
            }
        }
        return res;
    }

}
