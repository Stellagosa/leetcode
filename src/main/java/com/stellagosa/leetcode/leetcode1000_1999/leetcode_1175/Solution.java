package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1175;

/**
 * @Author: Stellagosa
 * @Date: 2022/6/30 10:22
 * @Description: 质数排列
 */
public class Solution {

    private static final int mod = 1000000007;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numPrimeArrangements(100));
    }

    public int numPrimeArrangements(int n) {
        int primeCount = 0;
        for (int i = 1; i <= n; i++) {
            if (isPrime(i)) primeCount++;
        }
        return (int) (factorial(primeCount) * factorial(n - primeCount) % mod);
    }

    private boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = (res * i) % mod;
        }
        return res;
    }

}
