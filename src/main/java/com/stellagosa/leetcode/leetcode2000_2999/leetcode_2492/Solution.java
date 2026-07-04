package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2492;

import java.util.*;

/**
 * @author Stellagosa
 * @description 两个城市见路径的最小分数
 * @date 7/4/2026 5:52 AM Saturday
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] roads = {{7,11,418},{13,23,287},{16,25,7891},{15,7,9695},{4,3,9569},{17,7,1809},{14,3,4720},{14,4,6118},{9,2,4290},
            {32,17,5645},{14,16,426},{36,7,6721},{13,30,9444},{3,25,4635},{33,5,1669},{22,18,8910},{5,28,7865},{13,10,9466},{7,9,2457},
                {11,8,4711},{17,11,6308},{7,34,3789},{8,33,9659},{16,3,4187},{16,20,3595},{23,10,6251},{26,22,6180},{4,16,5577},
                    {26,7,5398},{6,36,8671},{10,19,3028},{23,30,1330},{19,13,8315},{25,20,4740},{25,4,5818},{30,10,8030},{30,19,7527},
                        {28,6,6804},{21,27,1746},{18,9,5189},{7,27,6560},{20,14,2450},{27,32,3951},{2,21,3927},{1,15,9283},{3,20,5428},
                            {15,26,5871},{19,23,4533},{14,25,6992},{4,20,5831}};
        solution.minScore(36, roads);
    }

    public int minScore(int n, int[][] roads) {
        List<Integer>[] f = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            f[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            f[road[0]].add(road[1]);
            f[road[1]].add(road[0]);
        }

        boolean[] flags = new boolean[n + 1];
        flags[1] = true;
        flags[n] = true;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        queue.offer(n);

        while (!queue.isEmpty()) {
            Integer polled = queue.poll();
            for (Integer i : f[polled]) {
                if (flags[i]) continue;
                flags[i] = true;
                queue.offer(i);
            }
        }

        int min = Integer.MAX_VALUE;
        for (int[] road : roads) {
            if (flags[road[0]]) {
                min = Math.min(min, road[2]);
            }
        }
        return min;
    }


    // public int minScore(int n, int[][] roads) {
    //     Map<Integer, List<Integer>> f = new HashMap<>();
    //     for (int[] road : roads) {
    //         int u = road[0];
    //         int v = road[1];
    //         f.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
    //         f.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
    //     }
    //
    //     Queue<Integer> queue = new ArrayDeque<>();
    //     queue.offer(1);
    //     boolean[] flags = new boolean[n + 1];
    //     flags[1] = true;
    //     while (!queue.isEmpty()) {
    //         Integer polled = queue.poll();
    //         List<Integer> list = f.get(polled);
    //         if (list == null) continue;
    //         for (int i : list) {
    //             if (flags[i]) continue;
    //             flags[i] = true;
    //             queue.offer(i);
    //         }
    //     }
    //
    //     int min = Integer.MAX_VALUE;
    //     for (int[] road : roads) {
    //         if (flags[road[0]]) {
    //             min = Math.min(min, road[2]);
    //         }
    //     }
    //     return min;
    // }


    // 超内存
    // public int minScore(int n, int[][] roads) {
    //     List<List<int[]>> f = new ArrayList<>(n + 1);
    //     for (int i = 0; i <= n; i++) {
    //         f.add(new ArrayList<>());
    //     }
    //     for (int[] road : roads) {
    //         int node1 = road[0], node2 = road[1], w = road[2];
    //         f.get(node1).add(new int[]{node2, w});
    //         f.get(node2).add(new int[]{node1, w});
    //     }
    //
    //     Queue<Integer> queue = new ArrayDeque<>();
    //     // {当前节点}
    //     queue.offer(1);
    //     boolean[][] visited = new boolean[n + 1][n + 1];
    //     int res = Integer.MAX_VALUE;
    //     while (!queue.isEmpty()) {
    //         int polled = queue.poll();
    //         List<int[]> list = f.get(polled);
    //         for (int[] ints : list) {
    //             int cur = ints[0], w = ints[1];
    //             if (visited[polled][cur]) continue;
    //             res = Math.min(res, w);
    //             queue.offer(cur);
    //             visited[polled][cur] = true;
    //             visited[cur][polled] = true;
    //         }
    //     }
    //     return res;
    // }
}
