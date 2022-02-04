package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1716;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/15 9:32
 * @Description: 计算力扣银行的钱
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalMoney(10));
    }

    public int totalMoney(int n) {
        int countWeek = n / 7;
        int otherDay = n % 7;
        int total = 0;
        // 第一周28，以后每周多7
        int preWeek = 28;

        for (int i = 0; i < countWeek; i++) {
            total += preWeek;
            preWeek += 7;
        }

        int monday = countWeek + 1;
        while (otherDay-- > 0) {
            total += monday;
            monday++;
        }
        return total;
    }
}
