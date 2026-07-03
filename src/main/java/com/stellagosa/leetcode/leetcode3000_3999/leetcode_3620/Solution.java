package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3620;

import java.util.*;

/**
 * @author Stellagosa
 * @description 恢复网络路径
 * @date 7/3/2026 7:54 AM Friday
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[][] edges = {{0, 1, 5}, {1, 3, 10}, {0, 2, 3}, {2, 3, 4}};
        // int[][] edges = {{0,1,7},{1,4,5},{0,2,6},{2,3,6},{3,4,2},{2,4,6}};
        int[][] edges = {{0, 3, 50}, {2, 3, 95}, {0, 1, 100}, {1, 3, 17}, {0, 2, 76}, {1, 2, 43}};
        // boolean[] online = new boolean[]{true, true, true, true};
        // boolean[] online = new boolean[]{true, true, true, false, true};
        boolean[] online = new boolean[]{true, true, false, true};
        solution.findMaxPathScore(edges, online, 262);
    }


    int n;
    List<List<int[]>> f;
    long[] memo;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        n = online.length;

        f = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            f.add(new ArrayList<>());
        }
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            if (!online[u] || !online[v]) continue;
            f.get(u).add(new int[]{v, cost});
            l = Math.min(l, cost);
            r = Math.max(r, cost);
        }
        if (!check(k, l)) return -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(k, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }


    private boolean check(long k, int min) {
        memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(0, min) <= k;
    }

    private long dfs(int u, int min) {
        if (u == n - 1) return 0;
        if (memo[u] != -1) return memo[u];
        List<int[]> list = f.get(u);
        // 为什么除以2
        // 上一轮的dfs可能返回Long.MAX_VALUE，dfs(v, min) + cost 会溢出
        long costs = Long.MAX_VALUE / 2;
        for (int[] ints : list) {
            int v = ints[0];
            int cost = ints[1];
            if (cost < min) continue;
            costs = Math.min(costs, dfs(v, min) + cost);
        }
        memo[u] = costs;
        return costs;
    }


    // private boolean check(List<List<int[]>> f, int n, long k, int min) {
    //     // 到达 i 位置的最小花费 g(i)
    //     // 不加最后8个超时，加了最后2个超时
    //     long[] g = new long[n];
    //     Arrays.fill(g, Long.MAX_VALUE);
    //     // Queue<long[]> queue = new ArrayDeque<>();
    //     Queue<long[]> queue = new PriorityQueue<>((o1, o2) -> Long.compare(o1[1], o2[1]));
    //     // {当前节点，总花费}
    //     queue.offer(new long[]{0, 0});
    //     while (!queue.isEmpty()) {
    //         long[] poll = queue.poll();
    //         int u = (int) poll[0];
    //         long costs = poll[1];
    //         List<int[]> list = f.get(u);
    //         for (int[] ints : list) {
    //             int v = ints[0];
    //             int cost = ints[1];
    //             if (cost < min || costs + cost > k) continue;
    //             if (v == n - 1) return true;
    //             if (costs + cost > g[v]) continue;
    //             g[v] = costs + cost;
    //             queue.offer(new long[]{v, costs + cost});
    //         }
    //     }
    //     return false;
    // }


    // 超时
    // public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
    //     int n = online.length;
    //     if (edges.length == 0) return -1;
    //     // u->v1,u->v2 => {u, {{v1, cost1}, {v2, cost2}}}
    //     Map<Integer, List<long[]>> map = new HashMap<>();
    //     int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
    //     for (int[] edge : edges) {
    //         if (!map.containsKey(edge[0])) {
    //             map.put(edge[0], new ArrayList<>());
    //         }
    //         map.get(edge[0]).add(new long[]{edge[1], edge[2]});
    //         l = Math.min(l, edge[2]);
    //         r = Math.max(r, edge[2]);
    //     }
    //
    //     while (l < r) {
    //         int mid = (l + r + 1) / 2;
    //         if (check(map, online, k, n, mid)) {
    //             l = mid;
    //         } else {
    //             r = mid - 1;
    //         }
    //     }
    //     return check(map, online, k, n, r) ? r : -1;
    // }
    //
    // // 试图寻找一条路径，并且路径上的最小值不能小于 min
    // private boolean check(Map<Integer, List<long[]>> map, boolean[] online, long k, int n, int min) {
    //     Queue<long[]> queue = new ArrayDeque<>();
    //     // {当前节点，总花费}
    //     queue.offer(new long[]{0, 0});
    //     while (!queue.isEmpty()) {
    //         long[] poll = queue.poll();
    //         List<long[]> list = map.get((int) poll[0]);
    //         if (list == null) continue;
    //         for (long[] longs : list) {
    //             if (!online[(int) longs[0]] || longs[1] < min || poll[1] + longs[1] > k) continue;
    //             if (longs[0] == n - 1) return true;
    //             queue.offer(new long[] {longs[0], poll[1] + longs[1]});
    //         }
    //     }
    //     return false;
    // }


    // 超时
    // public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
    //     int n = online.length;
    //     if (edges.length == 0) return -1;
    //     Arrays.sort(edges, ((o1, o2) -> {
    //         if (o1[0] == o2[0]) return o1[2] - o2[2];
    //         return o1[0] - o2[0];
    //     }));
    //
    //     Map<Long, int[]> map = new HashMap<>();
    //     int pre_idx = 0;
    //     for (int i = 1; i < edges.length; i++) {
    //         if (edges[i][0] != edges[i - 1][0]) {
    //             map.put((long) edges[i - 1][0], new int[]{pre_idx, i - 1});
    //             pre_idx = i;
    //         }
    //     }
    //     if (!map.containsKey((long)edges[edges.length - 1][0])) {
    //         map.put((long) edges[edges.length - 1][0], new int[]{pre_idx, edges.length - 1});
    //     }
    //
    //     Queue<long[]> queue = new ArrayDeque<>();
    //     // {当前节点，总花费，最小边}
    //     queue.offer(new long[] {0, 0, Long.MAX_VALUE});
    //     long res = -1;
    //     while (!queue.isEmpty()) {
    //         long[] cur = queue.poll();
    //         int[] ints = map.get(cur[0]);
    //         if (ints == null) continue;
    //         int begin = ints[0], end = ints[1];
    //         for (int i = begin; i <= end; i++) {
    //             if (online[edges[i][1]] && cur[1] + edges[i][2] <= k) {
    //                 if (edges[i][1] == n - 1) {
    //                     res = Math.max(res, Math.min(edges[i][2], cur[2]));
    //                     continue;
    //                 }
    //                 queue.offer(new long[] {edges[i][1], cur[1] + edges[i][2], Math.min(cur[2], edges[i][2])});
    //             }
    //         }
    //     }
    //     return (int) res;
    // }
}
