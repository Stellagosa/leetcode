package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2003;

import java.util.*;

/**
 * @author Stellagosa
 * @description 每棵子树内缺失的最小基因值
 * @date 2023/10/31 15:16 星期二
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] parents = {-1, 0, 0, 2};
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.smallestMissingValueSubtree(parents, nums);
    }

    public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
        int n = nums.length;
        CustomList[] children = new CustomList[n];
        for (int i = 0; i < n; ++i) {
            children[i] = new CustomList();
        }
        for (int i = 0; i < n; ++i) {
            if (parents[i] == -1) continue;
            children[parents[i]].add(i);
        }

        int[] result = new int[n];
        Arrays.fill(result, 1);
        int node = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                node = i;
                break;
            }
        }

        Set<Integer> gene = new HashSet<>();
        boolean[] visited = new boolean[n];
        int iNode = 1;
        while (node != -1) {
            dfs(node, children, nums, gene, visited);
            while (gene.contains(iNode)) {
                iNode++;
            }
            result[node] = iNode;
            node = parents[node];
        }
        return result;
    }

    private void dfs(int node, CustomList[] children, int[] nums, Set<Integer> gene, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        visited[node] = true;
        gene.add(nums[node]);
        for (Integer child : children[node]) {
            dfs(child, children, nums, gene, visited);
        }
    }

    // public int[] smallestMissingValueSubtree(int[] parents, int[] nums) {
    //     int n = nums.length;
    //     CustomList[] children = new CustomList[n];
    //     for (int i = 0; i < n; ++i) {
    //         children[i] = new CustomList();
    //     }
    //     for (int i = 0; i < n; ++i) {
    //         if (parents[i] == -1) continue;
    //         children[parents[i]].add(i);
    //     }
    //
    //     int[] result = new int[n];
    //     Arrays.fill(result, 1);
    //
    //     CustomSet[] geneSet = new CustomSet[n];
    //     for (int i = 0; i < n; ++i) {
    //         geneSet[i] = new CustomSet();
    //     }
    //
    //     dfs(0, children, nums, geneSet, result);
    //     return result;
    // }
    //
    // private int dfs(int node, CustomList[] children, int[] nums, CustomSet[] geneSet, int[] result) {
    //     geneSet[node].add(nums[node]);
    //     for (Integer child : children[node]) {
    //         result[node] = Math.max(result[node], dfs(child, children, nums, geneSet, result));
    //         if (geneSet[node].size() < geneSet[child].size()) {
    //             CustomSet temp = geneSet[child];
    //             geneSet[child] = geneSet[node];
    //             geneSet[node] = temp;
    //         }
    //         geneSet[node].addAll(geneSet[child]);
    //     }
    //     while (geneSet[node].contains(result[node])) {
    //         result[node]++;
    //     }
    //     return result[node];
    // }
}

class CustomList extends ArrayList<Integer> {
    CustomList() {
        super();
    }
}

// class CustomSet extends HashSet<Integer> {
//     CustomSet() {
//         super();
//     }
// }

