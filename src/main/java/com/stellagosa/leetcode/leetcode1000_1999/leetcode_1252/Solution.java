package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1252;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/12 6:48
 * @Description: 奇数值单元格的数目
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] indices = {{0, 1}, {1, 1}};
        System.out.println(solution.oddCells(2, 3, indices));
    }

    public int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] cols = new int[n];
        Map<Integer, Integer> rMap = new HashMap<>();
        Map<Integer, Integer> cMap = new HashMap<>();

        for (int[] index : indices) {
            rows[index[0]]++;
            cols[index[1]]++;
        }
        int rOddCount = 0, cOddCount = 0;
        for (int row : rows) {
            rOddCount += (row & 1)!=0?1:0;
        }
        for (int col : cols) {
            cOddCount += (col & 1)!=0?1:0;
        }
        return rOddCount * n + cOddCount * m - 2 * rOddCount * cOddCount;
    }

    // public int oddCells(int m, int n, int[][] indices) {
    //     Map<Integer, Integer> rMap = new HashMap<>();
    //     Map<Integer, Integer> cMap = new HashMap<>();
    //
    //     for (int[] index : indices) {
    //         rMap.merge(index[0], 1, (newValue, oldValue) -> newValue + oldValue);
    //         cMap.merge(index[1], 1, (newValue, oldValue) -> newValue + oldValue);
    //     }
    //
    //     int rOddCount = 0, cOddCount = 0;
    //     for (Map.Entry<Integer, Integer> entry : rMap.entrySet()) {
    //         rOddCount += entry.getValue() % 2 == 0 ? 0 : 1;
    //     }
    //     for (Map.Entry<Integer, Integer> entry : cMap.entrySet()) {
    //         cOddCount += entry.getValue() % 2 == 0 ? 0 : 1;
    //     }
    //
    //     int res = 0;
    //     res += rOddCount * n + cOddCount * m - 2 * rOddCount * cOddCount;
    //     return res;
    // }
}

// 奇数行 奇数列 交点偶数 减两倍交点数
// 奇数行 偶数列  交点奇数  但是奇数行和奇数列时算过了
// 偶数行 奇数列 交点奇数 但是奇数行和奇数列时算过了
// 偶数行 偶数列 全偶数
