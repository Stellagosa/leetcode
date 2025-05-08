package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3341;

import java.util.*;

/**
 * @author Stellagosa
 * @description 到达最后一个房间的最少时间Ⅰ
 * @date 2025/5/8 8:22 星期四
 */
public class Solution {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] res = new int[n][m];
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean[][] flag = new boolean[n][m];
        flag[0][0] = true;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0, 0));
        flag[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int[] dir : dirs) {
                int next_x = node.x + dir[0];
                int next_y = node.y + dir[1];
                if (next_x < 0 || next_x >= n || next_y < 0 || next_y >= m) continue;
                if (flag[next_x][next_y]) continue;
                flag[next_x][next_y] = true;
                res[next_x][next_y] = Math.max(res[node.x][node.y], moveTime[next_x][next_y]) + 1;
                if (next_x == n - 1 && next_y == m - 1) return res[next_x][next_y];
                queue.offer(new Node(next_x, next_y, res[next_x][next_y]));
            }
        }

        return res[n - 1][m - 1];
    }

    private static class Node implements Comparable<Node> {
        int x, y, time;

        public Node(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

}
