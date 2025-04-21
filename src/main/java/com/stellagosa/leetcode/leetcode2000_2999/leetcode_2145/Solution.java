package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2145;

/**
 * @author Stellagosa
 * @description 统计隐藏数组数目
 * @date 2025/4/21 15:53 星期一
 */
public class Solution {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = differences[0];
        long max = differences[0];
        long sum = differences[0];
        for (int i = 1; i < differences.length; i++) {
            sum += differences[i];
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        long left = lower, right = upper;
        left = Math.max(lower - min, left);
        // 多余
        // left = Math.max(lower - max, left);
        // right = Math.min(upper - min, right);
        right = Math.min(upper - max, right);

        return right >= left ? (int) (right - left + 1) : 0;
    }

}
