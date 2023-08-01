package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2681;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/1 8:13
 * @Description: 英雄的力量
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {658, 489, 777, 2418, 1893, 130, 2448, 178, 1128, 2149, 1059, 1495, 1166, 608, 2006, 713, 1906, 2108,
                680, 1348, 860, 1620, 146, 2447, 1895, 1083, 1465, 2351, 1359, 1187,
                906, 533, 1943, 1814, 1808, 2065, 1744, 254, 1988, 1889, 1206};
        Solution solution = new Solution();
        System.out.println(solution.sumOfPower(nums));
    }

    /**
     * 有序的 a,b,c,d,e
     * 以d结尾的力量 d^3 + d^2(a*2^2 + b*2^1 + c*2^0)
     * 以e结尾的力量 e^3 + e^2(a*2^3 + b*2^2 + c*2^1 + d*2^0)
     * 令 s[d] = a*2^2 + b*2^1 + c*2^0
     * s[e] = 2*s[d] + d
     */
    public int sumOfPower(int[] nums) {
        int mod = (int) (1e9 + 7);
        Arrays.sort(nums);

        int result = 0;
        int s = 0;
        for (int num : nums) {
            result = (int) ((result + ((long) num * num) % mod * (num + s)) % mod);
            s = (int) ((2 * (long) s + num) % mod);
        }
        return result;
    }
}
