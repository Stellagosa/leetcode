package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2611;

import java.util.Arrays;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/7 上午 08:37
 * @Description: 老鼠和奶酪
 */
public class Solution {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int result = 0;
        int n = reward1.length;

        int[] diff = new int[n];

        // 全部被老鼠2吃了
        for (int i = 0; i < n; i++) {
            result += reward2[i];
            diff[i] = reward1[i] - reward2[i];
        }

        Arrays.sort(diff);

        for (int i = 0; i < k; i++) {
            result += diff[n - i - 1];
        }

        return result;
    }

}
