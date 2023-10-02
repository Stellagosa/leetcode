package com.stellagosa.leetcode.leetcode100_999.leetcode_122;

/**
 * @author Stellagosa
 * @description 买卖股票的最佳时机Ⅱ
 * @date 2023/10/2 8:00 星期一
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                result += prices[i + 1] - prices[i];
            }
        }
        return result;
    }
}
