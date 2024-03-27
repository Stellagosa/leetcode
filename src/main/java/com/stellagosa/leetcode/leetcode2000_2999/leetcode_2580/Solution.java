package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2580;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Stellagosa
 * @description 统计将重叠区间合并成组的方案数
 * @date 2024/3/27 13:17 星期三
 */
public class Solution {

    public int countWays(int[][] ranges) {
        int mod = 1000000007;

        Arrays.sort(ranges, Comparator.comparingInt(o -> o[0]));
        int count = 0, end = -1;
        for (int[] range : ranges) {
            if (range[0] <= end) {
                end = Math.max(end, range[1]);
            } else {
                count++;
                end = range[1];
            }
        }
        long result = 1, n = 2;
        while (count > 0) {
            if ((count & 1) == 1) {
                result = result * n % mod;
            }
            count >>= 1;
            n = n * n % mod;
        }
        return (int) result;
    }
}
