package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2812;

import java.util.*;

/**
 * @author Stellagosa
 * @description 找出最安全路径
 * @date 7/1/2026 7:47 AM Wednesday
 */
public class Solution {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,1},{0,0,0,0},{0,0,0,0},{1,0,0,0}};
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < grid[i].length; j++) {
                temp.add(grid[i][j]);
            }
            list.add(temp);
        }
        Solution solution = new Solution();
        solution.maximumSafenessFactor(list);
    }


    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) return 0;

        int[][] arr = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.offer(new int[]{i, j});
                    arr[i][j] = 0;
                } else {
                    arr[i][j] = -1;
                }
            }
        }

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < dir.length; j++) {
                    int x = poll[0] + dir[j][0];
                    int y = poll[1] + dir[j][1];
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        if (arr[x][y] == -1) {
                            arr[x][y] = arr[poll[0]][poll[1]] + 1;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, arr[i][j]);
            }
        }

        int l = 0, r = max;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (!check(arr, mid, n)) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    private boolean check(int[][] arr, int min, int n) {
        if (arr[0][0] < min || arr[n - 1][n - 1] < min) return false;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] flag = new boolean[n][n];
        flag[0][0] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                for (int j = 0; j < dir.length; j++) {
                    int x = poll[0] + dir[j][0];
                    int y = poll[1] + dir[j][1];

                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        if (arr[x][y] >= min && !flag[x][y]) {
                            if (x == n - 1 && y == n - 1) return true;
                            queue.offer(new int[] {x, y});
                            flag[x][y] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
