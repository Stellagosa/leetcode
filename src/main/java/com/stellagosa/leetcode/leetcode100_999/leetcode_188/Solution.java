package com.stellagosa.leetcode.leetcode100_999.leetcode_188;

/**
 * @author Stellagosa
 * @description 买卖股票的最佳时机Ⅳ
 * @date 2023/10/4 8:18 星期三
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(solution.maxProfit(2, prices));
    }

    public int maxProfit(int k, int[] prices) {
        k = Math.min(k, prices.length >> 1);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        for (int i = 0; i <= k; i++) {
            buy[i] = - prices[0];
        }
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k];
    }

}
