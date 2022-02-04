package com.stellagosa.leetcode.leetcode2000_2999.leetcode_2013;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Stellagosa
 * @Date: 2022/1/26 11:10
 * @Description: 检测正方形
 */
public class DetectSquares {

    Map<Integer, Integer> map;//统计次数
    Map<Integer, Set<Integer>> mapX;
    Map<Integer, Set<Integer>> mapY;

    public DetectSquares() {
        map = new HashMap<>();
        mapX = new HashMap<>();
        mapY = new HashMap<>();
    }

    public void add(int[] point) {
        map.merge(point[0] * 1001 + point[1], 1, Integer::sum);
        mapX.computeIfAbsent(point[0], k -> new HashSet<>());
        mapX.get(point[0]).add(point[1]);
        mapY.computeIfAbsent(point[1], k -> new HashSet<>());
        mapY.get(point[1]).add(point[0]);
    }

    public int count(int[] point) {
        int pointX = point[0], pointY = point[1];
        Set<Integer> setX = mapX.get(pointX);
        Set<Integer> setY = mapY.get(pointY);
        if (setX == null || setY == null) return 0;
        int res = 0;
        for (int num : setX) {
            int length = num - pointY; // 边长
            if (length == 0) continue;
            if (setY.contains(pointX + length)) {
                if (mapX.containsKey(pointX + length) && mapX.get(pointX + length).contains(num)) {
                    res += map.get(pointX * 1001 + num) * map.get((pointX + length) * 1001 + pointY) * map.get((pointX + length) * 1001 + num);
                }
            }
            if (setY.contains(pointX - length)) {
                if (mapX.containsKey(pointX - length) && mapX.get(pointX - length).contains(num)) {
                    res += map.get(pointX * 1001 + num) * map.get((pointX - length) * 1001 + pointY) * map.get((pointX - length) * 1001 + num);
                }
            }
        }
        return res;
    }


}
