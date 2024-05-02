package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2462;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author Stellagosa
 * @description 雇佣K位工人的总代价
 * @date 2024/5/2 7:28 星期四
 */
public class Solution {

    public long totalCost(int[] costs, int k, int candidates) {

        int n = costs.length;
        long res = 0;
        int p = Math.min(n - 1, candidates - 1);
        int q = Math.max(0, n - candidates);
        if (q <= p + 1) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                res += costs[i];
            }
            return res;
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> {
            if (costs[o1] != costs[o2]) {
                return costs[o1] - costs[o2];
            }
            return o1 < o2 ? -1 : 1;
        });
        for (int i = 0; i <= p; i++) {
            queue.offer(i);
        }
        for (int i = q; i < n; i++) {
            queue.offer(i);
        }

        while (k > 0) {
            Integer poll = queue.poll();
            if (p != q - 1) {
                if (poll <= p) {
                    p++;
                    queue.offer(p);
                } else {
                    q--;
                    queue.offer(q);
                }
            }
            res += costs[poll];
            k--;
        }
        return res;
    }


    // 超时
    // public long totalCost(int[] costs, int k, int candidates) {
    //     int n = costs.length;
    //     int p = Math.min(n - 1, candidates - 1);
    //     int q = Math.max(0, n - candidates);
    //     boolean[] flags = new boolean[n];
    //     long res = 0;
    //
    //     while (k > 0) {
    //         int index = -1;
    //         int min = Integer.MAX_VALUE;
    //         for (int i = n - 1; i >= q; i--) {
    //             if (!flags[i]) {
    //                 if (costs[i] <= min) {
    //                     index = i;
    //                     min = costs[i];
    //                 }
    //             }
    //         }
    //
    //         boolean flag = false;
    //         for (int i = p; i >= 0; i--) {
    //             if (!flags[i]) {
    //                 if (costs[i] <= min) {
    //                     flag = true;
    //                     index = i;
    //                     min = costs[i];
    //                 }
    //             }
    //         }
    //
    //         if (flag) {
    //             p = Math.min(n - 1, p + 1);
    //         } else {
    //             q = Math.max(0, q - 1);
    //         }
    //
    //         flags[index] = true;
    //         res += min;
    //         k--;
    //     }
    //     return res;
    // }

}
