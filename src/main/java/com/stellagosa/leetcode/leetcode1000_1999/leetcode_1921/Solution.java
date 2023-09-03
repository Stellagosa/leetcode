package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1921;

/**
 * @author Stellagosa
 * @description 消灭怪物的最大数量
 * @date 2023/9/3 9:45 星期日
 */
public class Solution {

    // o(n)
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] times = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int time = (dist[i] - 1) / speed[i] + 1; // 向上取整
            // 到达时间大于n的映射到n
            // 小于等于n的映射到n-1
            times[time > n ? n : time - 1]++;
        }

        int sum = 0; // 到达的怪物数量
        for (int i = 0; i < n; i++) {
            sum += times[i];
            if (sum > i + 1) return i + 1;
        }
        return n;
    }


    // o(n * log n)
    // public int eliminateMaximum(int[] dist, int[] speed) {
    //     int n = dist.length;
    //     int[] times = new int[n];
    //     for (int i = 0; i < n; i++) {
    //         times[i] = (dist[i] - 1) / speed[i] + 1; // 向上取整
    //     }
    //     Arrays.sort(times);
    //     for (int i = 0; i < n; i++) {
    //         if (times[i] < i) {
    //             return i;
    //         }
    //     }
    //     return n;
    // }
}
