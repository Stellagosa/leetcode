package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2924;

/**
 * @author Stellagosa
 * @description 找到冠军Ⅱ
 * @date 2024/4/13 5:41 星期六
 */
public class Solution {

    // 查找入度为零的点，出现多个返回-1
    public int findChampion(int n, int[][] edges) {
        int[] count = new int[n];
        for (int[] edge : edges) {
            count[edge[1]]++;
        }
        int result = -1;
        for (int i = 0; i < count.length; i++) {
            if (count[i] == 0) {
                if (result == -1) {
                    result = i;
                } else {
                    return -1;
                }
            }
        }
        return result;
    }

}
