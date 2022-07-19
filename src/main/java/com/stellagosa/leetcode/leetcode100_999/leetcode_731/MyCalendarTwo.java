package com.stellagosa.leetcode.leetcode100_999.leetcode_731;

import java.util.TreeMap;

/**
 * @Author: Stellagosa
 * @Date: 2022/7/19 6:42
 * @Description: 我的日程安排表Ⅱ
 */
public class MyCalendarTwo {

    TreeMap<Integer, Integer> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        int count = 0;
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        for (Integer value : map.values()) {
            count += value;
            if (count > 2) {
                map.put(start, map.getOrDefault(start, 0) - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);
                return false;
            }
        }
        return true;
    }
}


