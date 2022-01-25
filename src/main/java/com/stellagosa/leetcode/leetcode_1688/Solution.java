package com.stellagosa.leetcode.leetcode_1688;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/25 11:48
 * @Description: 比赛中的配对次数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfMatches(14));
    }

    public int numberOfMatches(int n) {
        return n - 1;
    }

    // public int numberOfMatches(int n) {
    //     if (n == 1) return 0;
    //     if (n == 2) return 1;
    //     if (n > 2 && n % 2 == 0) return n / 2 + numberOfMatches(n / 2);
    //     return n / 2 + numberOfMatches(1 + (n / 2));
    // }
}
