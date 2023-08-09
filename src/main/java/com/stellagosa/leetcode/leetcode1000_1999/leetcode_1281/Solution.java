package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1281;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/9 14:24
 * @Description: 整数的各位积和之差
 */
public class Solution {
    public int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            product *= temp;
            sum += temp;
            n /= 10;
        }
        return product - sum;
    }
}
