package com.stellagosa.leetcode.leetcode_1610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: Stellagosa
 * @Date: 2021/12/16 13:10
 * @Description: 可见点的最大数目
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] target = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {1, 2}, {2, 1}};
        List<List<Integer>> points = new ArrayList<>();
        for (int[] ints : target) {
            List<Integer> temp = new ArrayList<>();
            Arrays.stream(ints).forEach(temp::add);
            points.add(temp);
        }
        int angle = 0;
        List<Integer> location = new ArrayList<>();
        location.add(1);
        location.add(1);
        int res = solution.visiblePoints(points, angle, location);
        System.out.println(res);
    }

    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int loc = 0;
        int x = location.get(0);
        int y = location.get(1);
        List<Double> list = new ArrayList<>();
        for (List<Integer> point : points) {
            if (point.get(0).equals(x) && point.get(1).equals(y)) {
                loc++;
            } else {
                list.add(Math.atan2(point.get(1) - y, point.get(0) - x) * 180 / Math.PI);
            }
        }
        Collections.sort(list);

        int count = 0;
        int index = 0;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            list.add(list.get(i) + 360);
        }
        for (int i = 0; i < n; i++) {
            Double v1 = list.get(i);
            while (list.get(index) <= v1 + angle) {
                index++;
            }
            if (index - i > count) {
                count = index - i;
            }
        }
        return loc + count;
    }
}
