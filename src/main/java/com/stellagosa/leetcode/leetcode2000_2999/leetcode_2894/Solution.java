package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2894;

/**
 * @author Stellagosa
 * @description 分类求和并作差
 * @date 2025/5/27 16:35 星期二
 */
public class Solution {

    public int differenceOfSums(int n, int m) {
        int cnt = n / m;
        int num2 = m * cnt + cnt * (cnt - 1) * m / 2;
        int num1 = n + n * (n - 1) / 2 - num2;
        return num1 - num2;
    }


    // public int differenceOfSums(int n, int m) {
    //     int num1 = 0, num2 = 0;
    //     for (int i = 1; i <= n; i++) {
    //         if (i % m == 0) {
    //             num2 += i;
    //         } else {
    //             num1 += i;
    //         }
    //     }
    //     return num1 - num2;
    // }

}
