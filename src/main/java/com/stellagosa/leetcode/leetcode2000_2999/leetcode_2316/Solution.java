package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2316;

import java.util.Arrays;

/**
 * @author Stellagosa
 * @description 统计无向图中无法互相到达点对数
 * @date 2023/10/21 19:40 星期六
 */
public class Solution {

    public long countPairs(int n, int[][] edges) {
        UnionFind unionFind = new UnionFind(n);

        for (int[] edge : edges) {
            unionFind.union(edge[0], edge[1]);
        }

        long result = 0L;
        for (int i = 0; i < n; ++i) {
            int size = unionFind.getSize(unionFind.find(i));
            result += n - size;
        }
        return result >> 1;
    }

}

class UnionFind {

    int[] parents;
    int[] sizes;

    UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; ++i) {
            parents[i] = i;
        }
        sizes = new int[n];
        Arrays.fill(sizes, 1);
    }

    int find(int point) {
        if (parents[point] == point) return point;
        parents[point] = find(parents[point]);
        return parents[point];
    }

    void union(int point1, int point2) {
        int parent1 = find(point1);
        int parent2 = find(point2);
        if (parent1 != parent2) {
            if (sizes[parent1] < sizes[parent2]) {
                parents[parent1] = parent2;
                sizes[parent2] += sizes[parent1];
            } else {
                parents[parent2] = parent1;
                sizes[parent1] += sizes[parent2];
            }
        }
    }

    int getSize(int point) {
        return sizes[point];
    }

}
