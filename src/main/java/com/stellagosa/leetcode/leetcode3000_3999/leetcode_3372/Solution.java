package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3372;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Stellagosa
 * @description 连接两棵树后最大目标节点数目Ⅰ
 * @date 2025/5/28 9:44 星期三
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges1 = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
        int[][] edges2 = {{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}};
        Arrays.stream(solution.maxTargetNodes(edges1, edges2, 2)).forEach(System.out::println);
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int[] count1 = build(edges1, k);
        int[] count2 = build(edges2, k - 1);

        int max = Integer.MIN_VALUE;
        for (int i : count2) {
            max = Math.max(i, max);
        }
        for (int i = 0; i < count1.length; i++) {
            count1[i] += max;
        }
        return count1;
    }

    private int[] build(int[][] edges, int k) {
        int n = edges.length + 1;
        List<List<Integer>> lists = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            lists.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            lists.get(edge[0]).add(edge[1]);
            lists.get(edge[1]).add(edge[0]);
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = dfs(i, -1, lists, k);
        }
        return res;
    }

    private int dfs(int cur, int pre, List<List<Integer>> lists, int k) {
        if (k < 0) return 0;
        List<Integer> children = lists.get(cur);
        int res = 1;
        for (Integer child : children) {
            if (child != pre) {
                res += dfs(child, cur, lists, k - 1);
            }
        }
        return res;
    }


}
