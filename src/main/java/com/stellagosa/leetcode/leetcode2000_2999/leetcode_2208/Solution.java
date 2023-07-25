package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2208;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Stellagosa
 * @Date: 2023/7/25 20:10
 * @Description: 将数组和减半的最少操作次数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3, 8, 20};
        System.out.println(solution.halveArray(nums));
    }

    public int halveArray(int[] nums) {
        Queue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
        // Queue<Double> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
        double sum = 0;
        for (int num : nums) {
            sum += num;
            queue.offer((double) num);
        }
        double target = sum / 2;
        int result = 0;
        while (!queue.isEmpty() && sum > target) {
            double temp = queue.poll();
            temp /= 2;
            sum -= temp;
            queue.offer(temp);
            result++;
        }
        return result;
    }


}
