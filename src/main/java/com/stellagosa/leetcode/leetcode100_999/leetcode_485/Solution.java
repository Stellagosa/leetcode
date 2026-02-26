package com.stellagosa.leetcode.leetcode100_999.leetcode_485;

/**
 * @author Stellagosa
 * @description 最大连续 1 的个数
 * @date 2026/2/26 12:26 星期四
 */
public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for (int num : nums) {
            cur++;
            cur = num * cur;
            if (cur > max) max = cur;
        }
        return max;
    }


//    public int findMaxConsecutiveOnes(int[] nums) {
//        int n = nums.length;
//        int max = 0;
//        for (int i = 0; i < n;) {
//            if (nums[i] == 1) {
//                // 查找连续的最后一个1的位置
//                int j = i;
//                while (j < n && nums[j] == 1) j++;
//                if (j == n) {
//                    // 到了整个数组最后一位
//                    max = Math.max(max, n - i);
//                } else {
//                    // 当前 nums[j] == 0 nums[j - 1] == 1
//                    max = Math.max(max, j - i);
//                }
//                i = j;
//            } else {
//                i++;
//            }
//        }
//        return max;
//    }

}
