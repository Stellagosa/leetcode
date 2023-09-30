package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2136;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 全部开花的最早一天
 * @date 2023/9/30 8:40 星期六
 */
public class Solution {

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Integer[] sorted = new Integer[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = i;
        }
        Arrays.sort(sorted, (o1, o2) -> growTime[o2] - growTime[o1]);
        int start = 0;
        int max = 0;
        for (int i : sorted) {
            start += plantTime[i];
            max = Math.max(max, start + growTime[i]);
        }
        return max;
    }

    // public int earliestFullBloom(int[] plantTime, int[] growTime) {
    //     int n = plantTime.length;
    //     // growTime 从大到小排序的id
    //     int[] sorted = IntStream.range(0, n).boxed().sorted((o1, o2) -> growTime[o2] - growTime[o1]).mapToInt(Integer::intValue).toArray();
    //     int start = 0;
    //     int max = 0;
    //     for (int i : sorted) {
    //         start += plantTime[i];
    //         max = Math.max(max, start + growTime[i]);
    //     }
    //     return max;
    // }


    // public int earliestFullBloom(int[] plantTime, int[] growTime) {
    //     // queue太慢了
    //     Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
    //     int n = growTime.length;
    //     for (int i = 0; i < n; i++) {
    //         queue.offer(new int[]{growTime[i], i});
    //     }
    //     int start = 0;
    //     int max = 0;
    //     while (!queue.isEmpty()) {
    //         int[] poll = queue.poll();
    //         int grow = poll[0];
    //         int plant = plantTime[poll[1]];
    //         start += plant;
    //         max = Math.max(max, start + grow);
    //     }
    //     return max;
    // }
}
