package com.stellagosa.leetcode.leetcode100_999.leetcode_822;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Stellagosa
 * @Date: 2023/8/2 7:31
 * @Description: 翻转卡片游戏
 */
public class Solution {

    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                set.add(fronts[i]);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int front : fronts) {
            if (!set.contains(front)) {
                result = Math.min(result, front);
            }
        }

        for (int back : backs) {
            if (!set.contains(back)) {
                result = Math.min(result, back);
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
