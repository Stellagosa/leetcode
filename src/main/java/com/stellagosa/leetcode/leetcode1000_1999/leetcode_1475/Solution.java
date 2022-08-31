package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1475;

/**
 * @Author: Stellagosa
 * @Date: 2022/9/1 6:42
 * @Description: 商品折扣后的最终价值
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {8,4,6,2,3};
        int[] res = solution.finalPrices(prices);
        for (int item : res) {
            System.out.println(item);
        }
    }

    public int[] finalPrices(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            int target = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] <= prices[i]) {
                    target = prices[j];
                    break;
                }
            }
            prices[i] -= target;
        }
        return prices;
    }
}
