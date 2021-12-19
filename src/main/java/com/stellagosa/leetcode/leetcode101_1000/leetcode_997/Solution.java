package com.stellagosa.leetcode.leetcode101_1000.leetcode_997;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/19 11:39
 * @Description: 找到小镇的法官
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] trust = new int[][]{
                {1, 3}, {2, 3}
        };
        System.out.println(solution.findJudge(3, trust));
    }

    public int findJudge(int n, int[][] trust) {
        // 出度为0，入度为n-1
        int[] inDegree = new int[n];
        int[] outDegree = new int[n];
        for (int[] ints : trust) {
            outDegree[ints[0] - 1]++;
            inDegree[ints[1] - 1]++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0) {
                list.add(i + 1);
            }
        }
        if (list.size() != 1) {
            return -1;
        } else {
            return list.get(0);
        }
    }
}
