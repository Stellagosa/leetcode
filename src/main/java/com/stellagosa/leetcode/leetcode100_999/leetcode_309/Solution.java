package com.stellagosa.leetcode.leetcode100_999.leetcode_309;

/**
 * @author Stellagosa
 * @description 买卖股票的最佳时机含冷冻期
 * @date 2023/10/5 7:19 星期四
 */
public class Solution {


    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;
        int buy = Math.max(-prices[0], -prices[1]);
        int sell1 = 0;
        int sell2 = Math.max(sell1, prices[1] - prices[0]);
        for (int i = 2; i < n; i++) {
            int temp1 = Math.max(buy, sell1 - prices[i]);
            int temp2 = Math.max(sell2, buy + prices[i]);
            buy = temp1;
            sell1 = sell2;
            sell2 = temp2;
        }
        return sell2;
    }

    // public int maxProfit(int[] prices) {
    //     int n = prices.length;
    //     if (n <= 1) return 0;
    //     int[] buy = new int[n];
    //     int[] sell = new int[n];
    //     buy[0] = -prices[0];
    //     buy[1] = Math.max(buy[0], -prices[1]);
    //     sell[0] = 0;
    //     sell[1] = Math.max(sell[0], prices[1] - prices[0]);
    //     for (int i = 2; i < n; i++) {
    //         buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
    //         sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
    //     }
    //     return sell[n - 1];
    // }

}
