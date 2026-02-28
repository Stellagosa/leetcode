package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1680;

/**
 * @author Stellagosa
 * @description 连接连续二进制数字
 * @date 2026/2/28 21:04 星期六
 */
public class Solution {

    public int concatenatedBinary(int n) {
        int mod = 1000000007;
        int temp = 0;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                temp++;
            }
            res = (res << temp | i) % mod;
        }
        return (int) res;
    }


    // n + (n-1)*2^binaryLength(n) + (n-2)*2^(binaryLength(n)+binaryLength(n-1)) +...+
    // 记arr[i] = binaryLength(i)
    // n + (n-1)*2^arr[n] + (n-2)*2^arr[n]*2^arr[n-1] + ... +
    // public int concatenatedBinary(int n) {
    //     int mod = 1000000007;
    //     long res = n;
    //     long temp = 1;
    //     for (int i = n - 1; i > 0; i--) {
    //         temp = (temp * (1L << binaryLength(i + 1))) % mod;
    //         res = (res + (i * temp) % mod) % mod;
    //     }
    //     return (int) res;
    // }
    //
    // private int binaryLength(int num) {
    //     int res = 0;
    //     while (num > 0) {
    //         res++;
    //         num >>= 1;
    //     }
    //     return res;
    // }
}
