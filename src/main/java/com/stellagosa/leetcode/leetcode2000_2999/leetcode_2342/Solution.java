package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2342;

/**
 * @author Stellagosa
 * @description 数位和相等数对的最大和
 * @date 2023/11/18 13:07 星期六
 */
public class Solution {

    public int maximumSum(int[] nums) {
        int[][] sum = new int[82][2];
        for (int num : nums) {
            int x = num;
            int temp = 0;
            while (x > 0) {
                temp += x % 10;
                x /= 10;
            }
            if (num >= sum[temp][0]) {
                sum[temp][1] = sum[temp][0];
                sum[temp][0] = num;
            } else if (num > sum[temp][1]) {
                sum[temp][1] = num;
            }
        }
        int result = -1;
        for (int[] s : sum) {
            if (s[1] != 0) {
                result = Math.max(result, s[0] + s[1]);
            }
        }
        return result;
    }

}
