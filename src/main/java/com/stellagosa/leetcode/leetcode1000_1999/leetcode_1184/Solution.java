package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1184;

/**
 * @author Stellagosa
 * @description 公交站间的距离
 * @date 2024/9/16 17:44 星期一
 */
public class Solution {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) return distanceBetweenBusStops(distance, destination, start);
        int n = distance.length;
        int res1 = 0;
        for (int i = start; i < destination; i++) {
            res1 += distance[i];
        }

        int res2 = 0;
        for (int i = destination; i < start + n; i++) {
            res2 += distance[i % n];
        }
        return Math.min(res1, res2);
    }

}
