package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1833;

/**
 * @author Stellagosa
 * @description 雪糕的最大数量
 * @date 6/24/2026 10:07 PM June
 */
public class Solution {

    public int maxIceCream(int[] costs, int coins) {
        int[] fre = new int[100001];
        for (int cost : costs) {
            fre[cost]++;
        }
        int res = 0;
        for (int i = 1; i < 100001; i++) {
            if (coins >= i) {
                int buy = Math.min(fre[i], coins / i);
                coins -= buy * i;
                res += buy;
            } else {
                break;
            }
        }
        return res;
    }


}
