package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1499;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/21 8:25
 * @Description: 满足不等式的最大值
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] points = {{1, 3}, {2, 0}, {5, 10}, {6, -10}};
        System.out.println(solution.findMaxvalueOfEquation(points, 1));
    }

    // Max(yi+yj+|xi-xj|)=Max(yi+yj+xj-xi) = Max(xj+yj)+Max(yi-xi)
    // xj-xi <= k
    public int findMaxvalueOfEquation(int[][] points, int k) {
        int n = points.length;
        int result = Integer.MIN_VALUE;

        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> points[o2][1] - points[o2][0] - points[o1][1] + points[o1][0]));

        for (int i = 0; i < points.length; i++) {
            while (!queue.isEmpty() && points[i][0] - points[queue.peek()][0] > k) {
                queue.poll();
            }
            if (!queue.isEmpty()) {
                result = Math.max(result, points[i][0] + points[i][1] + points[queue.peek()][1] - points[queue.peek()][0]);
            }
            queue.offer(i);
        }
        return result;
    }
}
