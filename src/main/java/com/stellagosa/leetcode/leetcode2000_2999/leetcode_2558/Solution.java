package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2558;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Stellagosa
 * @description 从数量最多的堆取走礼物
 * @date 2023/10/28 8:12 星期六
 */
public class Solution {

    public long pickGifts(int[] gifts, int k) {
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int gift : gifts) {
            queue.offer(gift);
        }
        while (k > 0) {
            Integer poll = queue.poll();
            double exp = Math.sqrt(poll);
            queue.offer((int) exp);
            k--;
        }
        long result = 0;
        while (!queue.isEmpty()) {
            result += queue.poll();
        }
        return result;
    }

}
