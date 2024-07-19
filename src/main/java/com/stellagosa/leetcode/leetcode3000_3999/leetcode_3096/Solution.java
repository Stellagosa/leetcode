package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3096;

/**
 * @author Stellagosa
 * @description 得到更多分数的最少关卡数目
 * @date 2024/7/19 8:20 星期五
 */
public class Solution {

    public int minimumLevels(int[] possible) {
        int count = 0;
        for (int i : possible) {
            count += i == 0 ? -1 : 1;
        }
        int preCount = 0;
        for (int i = 0; i < possible.length - 1; i++) {
            preCount += possible[i] == 0 ? -1 : 1;
            if (preCount << 1 > count) return i + 1;
        }
        return -1;
    }

}
