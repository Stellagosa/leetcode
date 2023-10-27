package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1465;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 切割后面积最大的蛋糕
 * @date 2023/10/27 8:57 星期五
 */
public class Solution {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int mod = 1000000007;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        return (int) ((long) max(horizontalCuts, h) * max(verticalCuts, w) % mod);
    }

    private int max(int[] nums, int border) {
        int pre = 0, result = 0;
        for (int num : nums) {
            result = Math.max(num - pre, result);
            pre = num;
        }
        return Math.max(border - pre, result);
    }

}
