package com.stellagosa.leetcode.leetcode1000_1999.leetcode_1488;

import java.util.*;

/**
 * @author Stellagosa
 * @description 避免洪水泛滥
 * @date 2023/10/31 20:10 星期二
 */
public class Solution {

    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();

        for (int i = 0; i < n; ++i) {
            if (rains[i] == 0) {
                set.add(i);
            } else {
                result[i] = -1;
                if (map.containsKey(rains[i])) {
                    Integer loc = map.get(rains[i]);
                    Integer target = set.ceiling(loc);
                    if (target == null) {
                        return new int[0];
                    }
                    result[target] = rains[i];
                    set.remove(target);
                }
                map.put(rains[i], i);
            }
        }
        return result;
    }

    // public int[] avoidFlood(int[] rains) {
    //     int n = rains.length;
    //     int[] result = new int[n];
    //     Arrays.fill(result, -1);
    //     Map<Integer, Integer> map = new HashMap<>();
    //     List<Integer> list = new LinkedList<>();
    //
    //     for (int i = 0; i < n; ++i) {
    //         if (rains[i] == 0) {
    //             list.add(i);
    //         } else {
    //             if (map.containsKey(rains[i])) {
    //                 Integer loc = map.get(rains[i]);
    //                 boolean flag = false;
    //                 for (Integer l : list) {
    //                     if (l > loc) {
    //                         flag = true;
    //                         result[l] = rains[i];
    //                         list.remove(l);
    //                         break;
    //                     }
    //                 }
    //                 if (!flag) {
    //                     return new int[]{};
    //                 }
    //             }
    //             map.put(rains[i], i);
    //         }
    //     }
    //     for (Integer l : list) {
    //         result[l] = 1;
    //     }
    //     return result;
    // }

}
