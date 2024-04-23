package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1052;

/**
 * @author Stellagosa
 * @description 爱生气的书店老板
 * @date 2024/4/23 8:53 星期二
 */
public class Solution {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += grumpy[i] == 1 ? 0 : customers[i];
        }

        for (int i = 0; i < minutes; i++) {
            count += grumpy[i] == 1 ? customers[i] : 0;
        }

        int max = count;
        for (int i = minutes; i < n; i++) {
            count += grumpy[i] == 1 ? customers[i] : 0;
            count -= grumpy[i - minutes] == 1 ? customers[i - minutes] : 0;
            max = Math.max(max, count);
        }

        return max;
    }

}
