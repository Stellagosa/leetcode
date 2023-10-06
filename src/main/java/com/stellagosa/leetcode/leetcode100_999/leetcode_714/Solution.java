package com.stellagosa.leetcode.leetcode100_999.leetcode_714;

/**
 * @author Stellagosa
 * @description 买卖股票的最佳时机含手续费
 * @date 2023/10/6 10:08 星期五
 */
public class Solution {

    public int maxProfit(int[] prices, int fee) {
        int buy = Integer.MIN_VALUE;
        int sell = 0;
        for (int price : prices) {
            buy = Math.max(buy, sell - price);
            sell = Math.max(sell, buy + price - fee);
        }
        return sell;
    }

    // public int maxProfit(int[] prices, int fee) {
    //     int buy = -prices[0];
    //     int sell = 0;
    //     for (int i = 1; i < prices.length; i++) {
    //         buy = Math.max(buy, sell - prices[i]);
    //         sell = Math.max(sell, buy + prices[i] - fee);
    //     }
    //     return sell;
    // }


    // public int maxProfit(int[] prices, int fee) {
    //     int n = prices.length;
    //     int[] buy = new int[n];
    //     int[] sell = new int[n];
    //
    //     buy[0] = -prices[0];
    //     for (int i = 1; i < n; i++) {
    //         buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i]);
    //         sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i] - fee);
    //     }
    //     return sell[n - 1];
    // }

}
