package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1260;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/20 8:01
 * @Description: 二维网格迁移
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[][] grid = {{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}};
        // int[][] grid = {{1}, {2}, {3}, {4}, {5}};
        int[][] grid = {{-145, -111, 69, -3, 185, 83, 581, -283},
                {497, 125, 500, 72, -356, -448, 422, -393},
                {-562, -3, 51, 336, -591, -918, 290, 507},
                {562, -912, 407, -862, 178, 270, 633, -836},
                {-275, -663, -578, -857, 859, -2, 58, 885},
                {553, 836, -605, 193, -319, 238, -156, -587},
                {723, 481, -454, 275, -683, -937, -934, -400}};
        List<List<Integer>> lists = solution.shiftGrid(grid, 57);
        for (List<Integer> list : lists) {
            for (Integer num : list) {
                System.out.printf("%d\t", num);
            }
            System.out.println();
        }
    }

    // 计算出结果坐标直接放入
    // 坐标变换
    // 相当于一维数组向后平移k次
    // 原坐标(i,j) 一维坐标位置  i*n+j
    // 平移k次 => (i*n+j+k)%(m*n)
    // 目标坐标 (((i*n+j+k)%(m*n))/n,((i*n+j+k)%(m*n))%n)
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        List<List<Integer>> res = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                list.add(0);
            }
            res.add(list);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int target = (i * n + j + k) % (m * n);
                res.get(target / n).set(target % n, grid[i][j]);
            }
        }
        return res;
    }

    // 计算出起始坐标，挨个遍历
    // 坐标变换
    // k%n!=0时 (m-1-k/n,n-k%n)
    // k%n==0 ((m-k/n)%m,(n-k%n)%n)
    // public List<List<Integer>> shiftGrid(int[][] grid, int k) {
    //     int m = grid.length;
    //     int n = grid[0].length;
    //     k = k % (m * n);
    //
    //     List<List<Integer>> res = new ArrayList<>(m);
    //     int i, j;
    //     if (k % n == 0) {
    //         i = (m - k / n) % m;
    //         j = 0;
    //     } else {
    //         i = m - 1 - k / n;
    //         j = n - k % n;
    //     }
    //     int count = 0;
    //     List<Integer> list = new ArrayList<>(n);
    //     while (res.size() < m) {
    //         list.add(grid[i][j]);
    //         count++;
    //         if (count == n) {
    //             count = 0;
    //             res.add(list);
    //             list = new ArrayList<>(n);
    //         }
    //         j++;
    //         if (j == n) {
    //             j = 0;
    //             i++;
    //         }
    //         if (i == m) {
    //             i = 0;
    //         }
    //
    //     }
    //     return res;
    // }
}
