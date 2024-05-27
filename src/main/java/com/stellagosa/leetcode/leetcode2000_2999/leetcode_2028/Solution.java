package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2028;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 找出缺失的观察数据
 * @date 2024/5/27 11:37 星期一
 */
public class Solution {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = (m + n) * mean;
        int sum_m = 0;
        for (int roll : rolls) {
            sum_m += roll;
        }
        int sum_n = sum - sum_m;
        if (sum_n < n || sum_n > 6 * n) return new int[0];

        sum_n -= n; // 全部填 1
        int count_6 = sum_n / 5; // 计算填 6 的个数
        int num = sum_n % 5; // 剩下的一个

        int[] result = new int[n];

        Arrays.fill(result, 0, count_6, 6);
        if (count_6 < n) {
            Arrays.fill(result, count_6, count_6 + 1, num + 1);
        }
        if (count_6 + 1 < n) {
            Arrays.fill(result, count_6 + 1, n, 1);
        }
        return result;
    }

    // public int[] missingRolls(int[] rolls, int mean, int n) {
    //     int m = rolls.length;
    //     int sum = (m + n) * mean;
    //
    //     int sum_m = Arrays.stream(rolls).sum();
    //     int sum_n = sum - sum_m;
    //
    //     if (sum_n < n || sum_n > 6 * n) return new int[0];
    //
    //     int[] result = new int[n];
    //
    //     dp(result, 0, sum_n, n);
    //     return result;
    // }
    //
    // private void dp(int[] result, int index, int sum, int n) {
    //     if (index >= n) return;
    //
    //     if (sum - 6 >= n - index - 1) {
    //         result[index] = 6;
    //         sum -= 6;
    //     } else if (sum - 5 >= n - index - 1) {
    //         result[index] = 5;
    //         sum -= 5;
    //     } else if (sum - 4 >= n - index - 1) {
    //         result[index] = 4;
    //         sum -= 4;
    //     } else if (sum - 3 >= n - index - 1) {
    //         result[index] = 3;
    //         sum -= 3;
    //     } else if (sum - 2 >= n - index - 1) {
    //         result[index] = 2;
    //         sum -= 2;
    //     } else if (sum - 1 >= n - index - 1) {
    //         result[index] = 1;
    //         sum -= 1;
    //     }
    //     dp(result, index + 1, sum, n);
    // }

}
