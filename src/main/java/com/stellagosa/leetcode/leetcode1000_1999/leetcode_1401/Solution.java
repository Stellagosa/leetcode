package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1401;

/**
 * @Author: Stellagosa
 * @Date: 2023/6/25 16:53
 * @Description: 圆和矩形是否有重叠
 */
public class Solution {

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int a = func(x1, x2, xCenter);
        int b = func(y1, y2, yCenter);
        return a * a + b * b <= radius * radius;
    }

    // a<b
    // a、b将一维坐标分为三部分
    // c 位于不同部分返回不同的结果
    private int func(int a, int b, int c) {
        if (c >= a && c <= b) {
            return 0;
        }
        if (c < a) return a - c;
        return c - b;
    }
}
