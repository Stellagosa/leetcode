package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2918;

/**
 * @author Stellagosa
 * @description 数组的最小相等和
 * @date 2025/5/10 14:07 星期六
 */
public class Solution {

    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int count1 = 0, count2 = 0;
        for (int num1 : nums1) {
            count1 += num1 == 0 ? 1 : 0;
            sum1 += num1;
        }
        for (int num2 : nums2) {
            count2 += num2 == 0 ? 1 : 0;
            sum2 += num2;
        }

//        if (count1 == 0 && count2 == 0) {
//            return sum1 == sum2 ? sum1 : -1;
//        } else if (count1 == 0 || count2 == 0) {
//            if (count1 == 0) {
//                return sum1 >= sum2 + count2 ? sum1 : -1;
//            } else {
//                return sum2 >= sum1 + count1 ? sum2 : -1;
//            }
//        } else {
//            return Math.max(sum1 + count1, sum2 + count2);
//        }

        if ((count1 == 0 && sum1 < sum2 + count2) || (count2 == 0 && sum2 < sum1 + count1)) return -1;

        return Math.max(sum1 + count1, sum2 + count2);
    }

}
