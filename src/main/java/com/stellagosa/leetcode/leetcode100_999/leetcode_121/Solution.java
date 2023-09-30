package com.stellagosa.leetcode.leetcode100_999.leetcode_121;

/**
 * @author Stellagosa
 * @description 买卖股票的最佳时机
 * @date 2023/10/1 6:38 星期日
 */
public class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int minIndex = 0;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (prices[minIndex] > prices[i]) {
                minIndex = i;
            }
            result = Math.max(result, prices[i] - prices[minIndex]);
        }
        return result;
    }

}
