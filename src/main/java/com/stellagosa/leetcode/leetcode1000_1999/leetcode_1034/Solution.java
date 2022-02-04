package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1034;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/7 10:11
 */
public class Solution {

    // 第二版优化一下

    private static int preColor;
    private static int m;
    private static int n;

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1}, {1, 2}};
        int[][] res = colorBorder(grid, 0, 0, 3);
        for (int[] re : res) {
            for (int i : re) {
                System.out.println(i);
            }
        }
    }

    // 深度优先搜索
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;

        // false表示没有访问过，true表示以访问
        boolean[][] viewed = new boolean[m][n];
        // 存放边界节点
        List<int[]> border = new ArrayList<>();

        preColor = grid[row][col];
        // 递归寻找边界
        check(grid, viewed, border, row, col);
        // 遍历边界节点染成 color 色
        for (int[] b : border) {
            grid[b[0]][b[1]] = color;
        }
        return grid;
    }

    private static void check(int[][] grid, boolean[][] viewed, List<int[]> border, int row, int col) {
        // 判定是否越界
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return;
        }
        // 已访问
        if (viewed[row][col]) {
            return;
        }
        // 不在连通分量
        if (grid[row][col] != preColor) {
            return;
        }

        // 肯定是没有访问并且属于连通分量
        viewed[row][col] = true;
        // 判定是否是边界，是边界添加到border
        if (isBorder(grid, row, col)) {
            border.add(new int[]{row, col});
        }

        // 递归判断该点的4个邻居节点

        check(grid, viewed, border, row + 1, col);
        check(grid, viewed, border, row - 1, col);
        check(grid, viewed, border, row, col + 1);
        check(grid, viewed, border, row, col - 1);
    }

    // 判定是否是边界，是边界返回 true，否则返回 false
    private static boolean isBorder(int[][] grid, int row, int col) {
        // 是整个二维数组的边节点，那肯定是边界了
        if (row == 0 || row == m - 1 || col == 0 || col == n - 1) {
            return true;
        }

        // 不是边节点了，就要判断周围的4个点是否有颜色不同，存在，则该节点就是边界
        return grid[row - 1][col] != preColor
                || grid[row][col - 1] != preColor
                || grid[row + 1][col] != preColor
                || grid[row][col + 1] != preColor;
    }

//    private static int preColor;
//    private static int m;
//    private static int n;
//
//    public static void main(String[] args) {
//        int[][] grid = new int[][]{{1, 1}, {1, 2}};
//        int[][] res = colorBorder(grid, 0, 0, 3);
//        for (int[] re : res) {
//            for (int i : re) {
//                System.out.println(i);
//            }
//        }
//    }
//
//    // 深度优先搜索
//    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
//        m = grid.length;
//        n = grid[0].length;
//
//        // 0表示没有访问过，1表示以访问，2表示边界
//        int[][] viewed = new int[m][n];
//        preColor = grid[row][col];
//        // 递归寻找边界
//        check(grid, viewed, row, col);
//        // 将边界染成 color 色
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (viewed[i][j] == 2) {
//                    grid[i][j] = color;
//                }
//            }
//        }
//        return grid;
//    }
//
//    private static void check(int[][] grid, int[][] viewed, int row, int col) {
//        // 判定是否越界
//        if (row < 0 || row >= m || col < 0 || col >= n) {
//            return;
//        }
//        // 已访问
//        if (viewed[row][col] == 1 || viewed[row][col] == 2) {
//            return;
//        }
//        // 不在连通分量
//        if (grid[row][col] != preColor) {
//            return;
//        }
//
//        // 肯定是没有访问并且属于连通分量
//        // 判定是否是边界，是边界viewed置为2，不是边界置为1
//        if (isBorder(grid, row, col)) {
//            viewed[row][col] = 2;
//        } else {
//            viewed[row][col] = 1;
//        }
//
//        // 递归判断该点的4个邻居节点
//
//        check(grid, viewed, row + 1, col);
//        check(grid, viewed, row - 1, col);
//        check(grid, viewed, row, col + 1);
//        check(grid, viewed, row, col - 1);
//    }
//
//    // 判定是否是边界，是边界返回 true，否则返回 false
//    private static boolean isBorder(int[][] grid, int row, int col) {
//        // 是整个二维数组的边节点，那肯定是边界了
//        if (row == 0 || row == m - 1 || col == 0 || col == n - 1) {
//            return true;
//        }
//
//        // 不是边节点了，就要判断周围的4个点是否有颜色不同，存在，则该节点就是边界
//        return grid[row - 1][col] != preColor
//                || grid[row][col - 1] != preColor
//                || grid[row + 1][col] != preColor
//                || grid[row][col + 1] != preColor;
//    }
}
