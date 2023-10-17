package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2652;

/**
 * @author Stellagosa
 * @description 倍数求和
 * @date 2023/10/17 8:53 星期二
 */
public class Solution {

    public int sumOfMultiples(int n) {
        return sumOfArithmeticProgression(3, n / 3, 3)
                + sumOfArithmeticProgression(5, n / 5, 5)
                + sumOfArithmeticProgression(7, n / 7, 7)
                - sumOfArithmeticProgression(15, n / 15, 15)
                - sumOfArithmeticProgression(21, n / 21, 21)
                - sumOfArithmeticProgression(35, n / 35, 35)
                + sumOfArithmeticProgression(105, n / 105, 105);
    }

    // 等差数列前n项和
    private int sumOfArithmeticProgression(int a1, int n, int d) {
        return a1 * n + ((n * (n - 1) * d) >> 1);
    }

    // public int sumOfMultiples(int n) {
    //     int a = (n / 3) * (3 + n / 3 * 3) / 2;
    //     int b = (n / 5) * (5 + n / 5 * 5) / 2;
    //     int c = (n / 7) * (7 + n / 7 * 7) / 2;
    //     int d = (n / 15) * (15 + n / 15 * 15) / 2;
    //     int e = (n / 21) * (21 + n / 21 * 21) / 2;
    //     int f = (n / 35) * (35 + n / 35 * 35) / 2;
    //     int g = (n / 105) * (105 + n / 105 * 105) / 2;
    //     return a + b + c - d - e - f + g;
    // }

    // public int sumOfMultiples(int n) {
    //     int result = 0;
    //     for (int i = 3; i <= n; ++i) {
    //         if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
    //             result += i;
    //         }
    //     }
    //     return result;
    // }

}
