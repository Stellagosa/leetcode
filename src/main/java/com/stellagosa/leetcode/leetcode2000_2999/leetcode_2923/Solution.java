package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2923;

/**
 * @author Stellagosa
 * @description 找到冠军Ⅰ
 * @date 2024/4/12 13:36 星期五
 */
public class Solution {

    public int findChampion(int[][] grid) {
        int n = grid.length;
        int champion = 0;
        for (int i = 0; i < n; i++) {
            if (grid[i][champion] == 1) {
                champion = i;
            }
        }
        return champion;
    }

    // public int findChampion(int[][] grid) {
    //     int n = grid.length;
    //     int champion = 0;
    //     while (true) {
    //         boolean flag = false;
    //         for (int j = 0; j < n; j++) {
    //             if (champion == j) continue;
    //             if (grid[champion][j] != 1) {
    //                 champion = j;
    //                 flag = true;
    //                 break;
    //             }
    //         }
    //         if (!flag) break;
    //     }
    //     return champion;
    // }


}
