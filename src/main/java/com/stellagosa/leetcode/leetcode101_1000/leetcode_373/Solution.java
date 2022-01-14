package com.stellagosa.leetcode.leetcode101_1000.leetcode_373;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/14 11:51
 * @Description: 查找和最小的k对数字
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] num1 = {1, 1, 2};
        int[] num2 = {1, 2, 3};
        List<List<Integer>> res = solution.kSmallestPairs(num1, num2, 8);
        for (List<Integer> list : res) {
            System.out.printf("(%d,%d)\t", list.get(0), list.get(1));
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int m = nums1.length;
        int n = nums2.length;
        if (m * n <= k) {
            for (int num1 : nums1) {
                for (int num2 : nums2) {
                    List<Integer> list = new ArrayList<>();
                    list.add(num1);
                    list.add(num2);
                    res.add(list);
                }
            }
        } else {
            Queue<int[]> queue = new PriorityQueue<>(k, ((o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]));
            for (int i = 0; i < Math.min(k, m); i++) {
                queue.offer(new int[]{i, 0});
            }

            while (k > 0 && !queue.isEmpty()) {
                int[] poll = queue.poll();
                List<Integer> list = new ArrayList<>();
                list.add(nums1[poll[0]]);
                list.add(nums2[poll[1]]);
                res.add(list);
                if (poll[1] < n - 1) {
                    queue.offer(new int[]{poll[0], poll[1] + 1});
                }
                k--;
            }
        }
        return res;
    }
}
