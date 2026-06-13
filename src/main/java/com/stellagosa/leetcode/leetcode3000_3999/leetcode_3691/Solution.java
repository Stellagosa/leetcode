package com.stellagosa.leetcode.leetcode3000_3999.leetcode_3691;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Stellagosa
 * @description 最大子数组总值Ⅱ
 * @date 6/10/2026 7:11 AM June
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,3,2};
        solution.maxTotalValue(arr, 2);
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        int v = 32 - Integer.numberOfLeadingZeros(n);
        int[][] minV = new int[n][v];
        int[][] maxV = new int[n][v];

        for (int i = 0; i < n; i++) {
            minV[i][0] = nums[i];
            maxV[i][0] = nums[i];
        }

        for (int i = 1; i < v; i++) {
            for (int j = 0; (1 << (i - 1)) < n - j; j++) {
                minV[j][i] = Math.min(minV[j][i - 1], minV[j + (1 << (i - 1))][i - 1]);
                maxV[j][i] = Math.max(maxV[j][i - 1], maxV[j + (1 << (i - 1))][i - 1]);
            }
        }

        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0]-o1[0]);
        // add [i, n - 1]
        for (int i = 0; i < n; i++) {
            int j = 31 - Integer.numberOfLeadingZeros(n - 1 - i + 1);
            int min = Math.min(minV[i][j], minV[n - 1 - (1 << j) + 1][j]);
            int max = Math.max(maxV[i][j], maxV[n - 1  - (1 << j) + 1][j]);
            queue.offer(new int[] {max - min, i, n - 1});
        }

        long res = 0L;
        while (k > 0) {
            int[] top = queue.poll();
            res += top[0];
            if (top[1] < top[2]) {
                int j = 31 - Integer.numberOfLeadingZeros(top[2] - 1 - top[1] + 1);
                int min = Math.min(minV[top[1]][j], minV[top[2] - 1 - (1 << j) + 1][j]);
                int max = Math.max(maxV[top[1]][j], maxV[top[2] - 1 - (1 << j) + 1][j]);
                queue.offer(new int[]{max - min, top[1], top[2] - 1});
            }
            k--;
        }
        return res;
    }


    // public long maxTotalValue(int[] nums, int k) {
    //     int n = nums.length;
    //     Queue<Integer> queue = new PriorityQueue<>(k, Comparator.reverseOrder());
    //     for (int i = 0; i < n; i++) {
    //         int min = Integer.MAX_VALUE;
    //         int max = Integer.MIN_VALUE;
    //         for (int j = i; j < n; j++) {
    //             min = Math.min(min, nums[j]);
    //             max = Math.max(max, nums[j]);
    //             queue.add(max - min);
    //             if (queue.size() > k) queue.poll();
    //         }
    //     }
    //
    //     long res = 0;
    //     while (!queue.isEmpty()) {
    //         res += queue.poll();
    //     }
    //     return res;
    // }
}
