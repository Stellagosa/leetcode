package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2530;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Stellagosa
 * @description 执行k次操作后的最大分数
 * @date 2023/10/18 7:44 星期三
 */
public class Solution {

    public long maxKelements(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : nums) {
            queue.offer(num);
        }

        long result = 0;

        for (int i = 0; i < k; ++i) {
            Integer poll = queue.poll();
            result += poll;
            // queue.offer((int) Math.ceil((double) poll / 3));
            queue.offer((poll + 2) / 3);
        }
        return result;
    }

}
