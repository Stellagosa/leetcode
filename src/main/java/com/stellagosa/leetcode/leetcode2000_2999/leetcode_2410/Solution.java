package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2410;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 运动员和训练师的最大匹配数
 * @date 2025/7/13 11:04 星期日
 */
public class Solution {

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i = 0, j = 0, res = 0;
        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                i++;
                j++;
                res++;
            } else {
                j++;
            }
        }
        return res;
    }

}
