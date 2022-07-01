package com.stellagosa.leetcode.leetcode100_999.leetcode_871;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/2 6:43
 * @Description: 最低加油次数
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};
        System.out.println(solution.minRefuelStops(100, 10, stations));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) return 0;
        Queue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1)); // 把油料带在车上
        int times = 0;

        for (int i = 0; i < stations.length; i++) {
            while (startFuel < stations[i][0]) {
                if (queue.isEmpty()) return -1;
                startFuel += queue.poll();
                times++;
            }
            queue.add(stations[i][1]);
        }

        while (startFuel < target) {
            if (queue.isEmpty()) return -1;
            startFuel += queue.poll();
            times++;
        }
        return times;
    }

}
