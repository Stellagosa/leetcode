package com.stellagosa.leetcode.leetcode_2029;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/20 10:24
 * @Description: 石子游戏Ⅳ
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] stones = {};
        System.out.println(solution.stoneGameIX(stones));
    }

    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int val : stones) {
            int type = val % 3;
            if (type == 0) {
                ++cnt0;
            } else if (type == 1) {
                ++cnt1;
            } else {
                ++cnt2;
            }
        }
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }
        return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
    }
}
