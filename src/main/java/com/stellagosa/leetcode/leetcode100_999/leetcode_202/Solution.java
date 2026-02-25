package com.stellagosa.leetcode.leetcode100_999.leetcode_202;

/**
 * @author Stellagosa
 * @description 快乐数
 * @date 2026/2/25 22:43 星期三
 */
public class Solution {

    public boolean isHappy(int n) {
        for (int i = 0; i < 10; i++) {
            int sum = sumOfNum(n);
            if (sum == 1) return true;
            n = sum;
        }
        return false;
    }

    private int sumOfNum(int num) {
        int count = 0;
        while (num > 0) {
            count += (num % 10) * (num % 10);
            num /= 10;
        }
        return count;
    }

}
