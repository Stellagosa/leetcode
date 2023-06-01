package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2517;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/1 上午 10:33
 * @Description: 礼盒的最大甜蜜度
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] price = {13, 5, 1, 8, 21, 2};
        int result = solution.maximumTastiness(price, 3);
        System.out.println(result);
    }

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < price.length; i++) {
            min = Math.min(min, price[i] - price[i - 1]);
        }
        int left = min, right = price[price.length - 1] - price[0];
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (check(price, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    // 检查是否存在k个糖果，并且这k个糖果组成的礼盒的甜蜜度是 tastiness
    // 存在这样的k个糖果，返回 true，否则返回 false
    private boolean check(int[] price, int k, int tastiness) {
        int count = 1;
        int pre = price[0];
        for (int i = 1; i < price.length; i++) {
            if (price[i] - pre >= tastiness) {
                count++;
                pre = price[i];
            }
        }
        return count >= k;
    }
}
