package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3286;

import java.util.*;

/**
 * @author Stellagosa
 * @description 穿越网格图的安全路径
 * @date 7/2/2026 8:16 AM Thursday
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] g = {{0,1,0,0,0},{0,1,0,1,0},{0,0,0,1,0}};
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < g.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < g[i].length; j++) {
                temp.add(g[i][j]);
            }
            grid.add(temp);
        }

        solution.findSafeWalk(grid, 1);
    }


    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.getFirst().size();
        Queue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));
        queue.offer(new int[]{grid.get(0).get(0), 0, 0});
        int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] costs = new int[m][n];
        for (int[] cost : costs) {
            Arrays.fill(cost, - 1);
        }
        costs[0][0] = grid.get(0).get(0);
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] >= health) return false;
            for (int[] ints : dir) {
                int nx = poll[1] + ints[0];
                int ny = poll[2] + ints[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (costs[nx][ny] == -1) {
                        costs[nx][ny] = poll[0] + grid.get(nx).get(ny);
                        if (nx == m - 1 && ny == n - 1) return costs[nx][ny] < health;
                        queue.offer(new int[] {costs[nx][ny], nx, ny});

                    }
                }
            }
        }
        return costs[m - 1][n - 1] < health;
    }
}
