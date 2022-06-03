package com.stellagosa.leetcode.leetcode100_999.leetcode_829;

/**
 * @Author: Stellagosa
 * @Date: 2022/06/03 18:06
 * @Description: 连续整数求和
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.consecutiveNumbersSum(10));
    }

    public int consecutiveNumbersSum(int n) {
        int res = 0;
        int k = 1;
        int temp = 0;
        while (n > temp) {
            if ((n - temp) % k == 0) res++;
            k++;
            temp = k * (k - 1) / 2;
        }
        return res;
    }
}


// 一个数n可以由k个连续的正整数表示
// a1,a2,a3,a4,...,ak
// n=k*(a1+ak)/2=k(a1+a1+k-1)/2=k*a1+k(k-1)/2
// a1=(n-k(k-1)/2)/k
// a1>0 => (n-k(k-1)/2)/k>0 => n-k(k-1)/2>0
// => n>k(k-1)/2



