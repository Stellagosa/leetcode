package com.stellagosa.leetcode.leetcode101_1000.leetcode_539;

import java.util.*;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/18 10:41
 * @Description: 最小时间差
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("00:00");
        list.add("00:00");
        System.out.println(solution.findMinDifference(list));
    }

    public int findMinDifference(List<String> timePoints) {
        if (timePoints.size() > 1440) return 0;
        Collections.sort(timePoints);

        int min = Integer.MAX_VALUE;
        int pre = convertToInt(timePoints.get(0));
        for (int i = 1; i < timePoints.size(); i++) {
            int cur = convertToInt(timePoints.get(i));
            min = Math.min(min, cur - pre);
            pre = cur;
        }
        return Math.min(min, convertToInt(timePoints.get(0)) + 1440 - pre);
    }

    // public int findMinDifference(List<String> timePoints) {
    //     if (timePoints.size() > 1440) return 0;
    //     Queue<Integer> queue = new PriorityQueue<>();
    //     for (String point : timePoints) {
    //         queue.offer(convertToInt(point));
    //     }
    //     int first = queue.poll();
    //     int pre = first;
    //     int min = Integer.MAX_VALUE;
    //
    //     while (!queue.isEmpty()) {
    //         int cur = queue.poll();
    //         min = Math.min(min, cur - pre);
    //         pre = cur;
    //     }
    //     return Math.min(min, first + 1440 - pre);
    // }

    private int convertToInt(String str) {
        String[] split = str.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
