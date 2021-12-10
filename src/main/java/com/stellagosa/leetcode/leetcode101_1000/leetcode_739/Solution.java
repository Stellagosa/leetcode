package com.stellagosa.leetcode.leetcode101_1000.leetcode_739;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/8 22:00
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{
                73, 74, 75, 71, 69, 72, 76, 73
        };
        int[] res = solution.dailyTemperatures(nums);
        for (int re : res) {
            System.out.println(re);
        }
    }

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;

        int[] res = new int[len];
        //[30,100] 映射到 [0,70]
        int[] key = new int[71];
        int max = 0;
        for (int i = 0; i < 71; i++) {
            key[i] = -1;
        }

        for (int i = len - 1; i >= 0; i--) {
            key[T[i] - 30] = i;
            max = Math.max(max, T[i]);
            int minIndex = Integer.MAX_VALUE;
            for (int j = T[i] + 1; j <= max; j++) {
                if (key[j - 30] != -1) {
                    minIndex = Math.min(minIndex, key[j - 30]);
                    break;
                }
            }
            if (minIndex == Integer.MAX_VALUE) {
                res[i] = 0;
            } else {
                res[i] = minIndex - i;
            }
        }
        return res;
    }
}
